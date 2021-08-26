# Architectural Decision Record

## 2021-08-26

* Logging - `io.github.microutils:kotlin-logging-jvm:2.0.10`
* OpenAPI 3 and Swagger UI - `org.springdoc:springdoc-openapi-ui:1.5.10`

Initial API sketch - Need a way to add schemas (versions).  The idea being, a newly deployed
service would register itself with this schema manager, and post a url where the
system can retrieve the current schema.   The schema manager can then do a diff with the previous
version.

Need to start designing the domain model.

For the moment we can ignore:
* Environments - Support for multiple deployments of an API (staging, qa, dev prod environments)
  can be added later.
* Services that do not have the ability to produce their own API schema.
* Anything but OpenAPI 3.x :)
* Versioned APIs - Where the service provides multiple versions of the API on different paths.
  * Maybe we can make something that will split the OpenAPI spec into separate 
    specs based on the path?
  
Other notes:
* Kotlin data classes seem to work well as request body objects.  That's good.


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