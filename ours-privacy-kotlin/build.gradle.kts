plugins {
    id("ours-privacy.kotlin")
    id("ours-privacy.publish")
}

dependencies {
    api(project(":ours-privacy-kotlin-client-okhttp"))
}
