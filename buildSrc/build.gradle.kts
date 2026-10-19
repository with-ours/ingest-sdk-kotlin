plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.9.25"
    id("com.vanniktech.maven.publish") version "0.35.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.35.0")
}
