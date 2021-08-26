package org.crispy.app.api

import mu.KLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Updating and accessing the schema for a given API.
 */
@RestController
@RequestMapping("api/v1/schema")
class Schema {
    companion object : KLogging()

    data class SchemaRequest(val name: String, val url: String?)

    /**
     * Registers a new schema.
     */
    @PostMapping()
    fun createSchema(@RequestBody schema: SchemaRequest) {
        logger.info { "createSchema: $schema"}
    }
}