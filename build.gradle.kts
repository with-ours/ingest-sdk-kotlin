buildscript {
    dependencies {
        // Dokka's Jackson parser also needs the security fixes used by the SDK.
        classpath(platform("com.fasterxml.jackson:jackson-bom:2.23.0"))
    }
}

plugins {
    // Lets the root project read Maven BOMs such as jackson-bom as platforms.
    `jvm-ecosystem`
    id("org.jetbrains.dokka") version "2.3.0"
}

repositories {
    mavenCentral()
}

allprojects {
    group = "com.oursprivacy"
    version = "1.29.0" // x-release-please-version
}

subprojects {
    // These are populated with dependencies by `buildSrc` scripts.
    tasks.register("format") {
        group = "Verification"
        description = "Formats all source files."
    }
    tasks.register("lint") {
        group = "Verification"
        description = "Verifies all source files are formatted."
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

allprojects {
    plugins.withId("org.jetbrains.dokka") {
        dependencies {
            // The Dokka worker has its own classpath, which the buildscript platform above doesn't reach.
            "dokkaHtmlGeneratorRuntime"(platform("com.fasterxml.jackson:jackson-bom:2.23.0"))
        }
    }
}

dependencies {
    subprojects.forEach { dokka(project(it.path)) }
}
