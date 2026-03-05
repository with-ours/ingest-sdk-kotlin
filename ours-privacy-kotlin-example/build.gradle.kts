plugins {
    id("ours-privacy.kotlin")
    application
}

dependencies {
    implementation(project(":ours-privacy-kotlin-core"))
    implementation(project(":ours-privacy-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :ours-privacy-kotlin-example:run` to run `Main`
    // Use `./gradlew :ours-privacy-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.oursprivacy.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
