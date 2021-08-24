# Architectural Decision Record

## 2021-08-24

* Main idea: Make a service that can automatically register and diff OpenAPI specs over time.
* How to diff OpenAPI schemas?
  * Discovered https://github.com/OpenAPITools/openapi-diff which seems to be a good way to parse OpenAPI and generate diffs.  Works on the v3 and v2 petstore examples.
  
* Modules
  * Logic module - the business logic
  * App module - The service itself.  Probably Spring Boot.
* Tooling
  * Kotlin / Gradle build for now.
  
### Notes

* Build
  * Need to apply the kotlin plugin 