plugins {
    id("org.springframework.boot") version "2.5.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
}

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        dependencies {
            dependency("org.openapitools.openapidiff:openapi-diff-core:2.0.0-beta.10")
            dependency("org.junit.jupiter:junit-jupiter-api:5.7.2")
            dependency("org.junit.jupiter:junit-jupiter-params:5.7.2")
            dependency("org.junit.jupiter:junit-jupiter-engine:5.7.2")
        }
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }
}

