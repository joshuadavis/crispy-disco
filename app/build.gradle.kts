apply(plugin = "org.springframework.boot")

dependencies {
    implementation(project(":logic"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springdoc:springdoc-openapi-ui")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
