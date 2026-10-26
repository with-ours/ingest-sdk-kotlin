import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("ours-privacy.kotlin")
    id("ours-privacy.publish")
}

// CI also verifies the patched version published to consumers.
val jacksonTestVersion = providers.gradleProperty("jacksonTestVersion").getOrElse("2.14.0")

configurations.matching {
    it.name in setOf("compileClasspath", "runtimeClasspath", "testCompileClasspath", "testRuntimeClasspath")
}.configureEach {
    resolutionStrategy {
        // Compile and test against a lower Jackson version to ensure we're compatible with it. Note that
        // we generally support 2.13.4, but test against 2.14.0 because 2.13.4 has some annoying (but
        // niche) bugs (users should upgrade if they encounter them). We publish with a higher version
        // (see below) to ensure users depend on a secure version by default.
        force("com.fasterxml.jackson.core:jackson-core:$jacksonTestVersion")
        force("com.fasterxml.jackson.core:jackson-databind:$jacksonTestVersion")
        force("com.fasterxml.jackson.core:jackson-annotations:$jacksonTestVersion")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonTestVersion")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonTestVersion")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonTestVersion")
    }
}

// Keep the mock server's Jackson independent of the SDK compatibility matrix. The test-only
// archive is never published and uses the maintained Jetty 12 server with patched dependencies.
val wiremockServer = configurations.create("wiremockServer")
val wiremockJar = tasks.register<ShadowJar>("wiremockJar") {
    archiveClassifier.set("wiremock-test-server")
    configurations = listOf(wiremockServer)
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    relocate("com.fasterxml.jackson", "com.oursprivacy.test.wiremock.jackson")
    mergeServiceFiles()
    // A classpath-only test archive cannot carry its dependencies' module descriptors.
    exclude("module-info.class", "META-INF/versions/**/module-info.class")
    listOf("META-INF/LICENSE", "META-INF/NOTICE", "META-INF/LICENSE.txt",
        "META-INF/NOTICE.txt", "META-INF/DEPENDENCIES").forEach { append(it) }
}

dependencies {
    wiremockServer("org.wiremock:wiremock-jetty12:3.13.2")
    wiremockServer(platform("org.eclipse.jetty:jetty-bom:12.0.40"))
    wiremockServer(platform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.40"))
    wiremockServer(platform("com.fasterxml.jackson:jackson-bom:2.21.8"))
    constraints {
        add(wiremockServer.name, "com.github.jknack:handlebars:4.5.5")
        add(wiremockServer.name, "org.apache.commons:commons-lang3:3.21.0")
        add(wiremockServer.name, "org.apache.httpcomponents.client5:httpclient5:5.6.5")
        add(wiremockServer.name, "org.apache.httpcomponents.core5:httpcore5:5.4.4")
        add(wiremockServer.name, "org.apache.httpcomponents.core5:httpcore5-h2:5.4.4")
        add(wiremockServer.name, "net.minidev:json-smart:2.6.0")
    }
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-core:2.18.12")
    api("com.fasterxml.jackson.core:jackson-databind:2.18.12")
    api("com.google.errorprone:error_prone_annotations:2.33.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.12")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.18.12")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.12")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.12")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    testImplementation(kotlin("test"))
    testImplementation(project(":ours-privacy-kotlin-client-okhttp"))
    testImplementation(files(wiremockJar))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.slf4j:slf4j-nop:2.0.18")
}
