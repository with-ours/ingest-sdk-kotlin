plugins {
    id("ours-privacy.kotlin")
    id("ours-privacy.publish")
}

// CI also verifies the patched version published to consumers.
val jacksonTestVersion = providers.gradleProperty("jacksonTestVersion").getOrElse("2.14.0")

configurations.all {
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
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.slf4j:slf4j-nop:1.7.36")
}
