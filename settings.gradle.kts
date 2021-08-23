pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        id("org.jetbrains.kotlin.jvm") version "${kotlinVersion}"
    }
}


rootProject.name = "crispy-disco"
include("openapi-parser")
