plugins {
    id("org.jetbrains.dokka") version "2.2.0"
}

repositories {
    mavenCentral()
}

allprojects {
    group = "com.oursprivacy"
    version = "1.24.0" // x-release-please-version
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

dependencies {
    subprojects.forEach { dokka(project(it.path)) }
}
