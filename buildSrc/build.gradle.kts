plugins {
    `kotlin-dsl`
    // Keep the applied buildSrc plugin patched as well as the SDK convention plugin.
    kotlin("jvm") version "2.4.21"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.21")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.37.0")
    implementation("com.gradleup.shadow:shadow-gradle-plugin:9.6.1")
}
