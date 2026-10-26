plugins {
    id("ours-privacy.kotlin")
    id("com.gradleup.shadow")
}

buildscript {
    repositories {
        google()
    }

    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.10.0")
        classpath("com.android.tools:r8:9.5.26")
    }
}

dependencies {
    testImplementation(project(":ours-privacy-kotlin"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")
}

tasks.shadowJar {
    // No relocation is used; preserve module metadata instead of remapping it.
    @Suppress("DEPRECATION")
    enableKotlinModuleRemapping = false
    from(sourceSets.test.get().output)
    configurations = listOf(project.configurations.testRuntimeClasspath.get())
}

val proguardJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-proguard.jar"
val proguardJar = tasks.register<proguard.gradle.ProGuardTask>("proguardJar") {
    group = "verification"
    dependsOn(tasks.shadowJar)
    notCompatibleWithConfigurationCache("ProGuard")

    injars(tasks.shadowJar.flatMap { it.archiveFile })
    outjars(proguardJarPath)
    printmapping("${layout.buildDirectory.get()}/proguard-mapping.txt")

    val javaHome = System.getProperty("java.home")
    if (System.getProperty("java.version").startsWith("1.")) {
        // Before Java 9, the runtime classes were packaged in a single jar file.
        libraryjars("$javaHome/lib/rt.jar")
    } else {
        // As of Java 9, the runtime classes are packaged in modular jmod files.
        libraryjars(
            // Filters must be specified first, as a map.
            mapOf("jarfilter" to "!**.jar", "filter" to "!module-info.class"),
            "$javaHome/jmods/java.base.jmod"
        )
    }

    configuration("./test.pro")
    configuration("../ours-privacy-kotlin-core/src/main/resources/META-INF/proguard/ours-privacy-kotlin-core.pro")
}

val testProGuard = tasks.register<JavaExec>("testProGuard") {
    group = "verification"
    dependsOn(proguardJar)
    notCompatibleWithConfigurationCache("ProGuard")

    mainClass.set("com.oursprivacy.proguard.ProGuardCompatibilityTest")
    classpath = files(proguardJarPath)
}

val r8JarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-r8.jar"
val r8Jar = tasks.register<JavaExec>("r8Jar") {
    group = "verification"
    dependsOn(tasks.shadowJar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set("com.android.tools.r8.R8")
    classpath = buildscript.configurations["classpath"]

    args = listOf(
        "--release",
        "--classfile",
        "--output", r8JarPath,
        "--lib", System.getProperty("java.home"),
        "--pg-conf", "./test.pro",
        "--pg-conf", "../ours-privacy-kotlin-core/src/main/resources/META-INF/proguard/ours-privacy-kotlin-core.pro",
        "--pg-map-output", "${layout.buildDirectory.get()}/r8-mapping.txt",
        tasks.shadowJar.get().archiveFile.get().asFile.absolutePath,
    )
}

val testR8 = tasks.register<JavaExec>("testR8") {
    group = "verification"
    dependsOn(r8Jar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set("com.oursprivacy.proguard.ProGuardCompatibilityTest")
    classpath = files(r8JarPath)
}

tasks.test {
    dependsOn(testProGuard)
    dependsOn(testR8)
    // We defer to the tests run via the ProGuard JAR.
    enabled = false
}
