plugins {
    id("org.springframework.boot") version "2.5.4" apply(false)
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.30"
    kotlin("plugin.spring") version "1.5.30"
}

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        // We need to import the Spring Boot BOM because we're *not* applying the spring boot plugin to every
        // module.   However, we do need the dependencies.
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
        overriddenByDependencies(false)
        dependencies {
            dependency("org.openapitools.openapidiff:openapi-diff-core:2.0.0-beta.10")
            dependency("io.github.microutils:kotlin-logging-jvm:3.0.3")
            dependency("org.springdoc:springdoc-openapi-ui:1.5.10")
        }
    }

    dependencies {
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        implementation("io.github.microutils:kotlin-logging-jvm")

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

