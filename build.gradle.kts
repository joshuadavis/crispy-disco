plugins {
    id("org.jetbrains.kotlin.jvm")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        constraints {
            // implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.12.4")
            // implementation("io.swagger.parser.v3:swagger-parser:2.0.27")
            implementation("org.openapitools.openapidiff:openapi-diff-core:2.0.0-beta.10")

            testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
            testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
            testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
            testRuntimeOnly("ch.qos.logback:logback-classic:1.2.5")
        }

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

