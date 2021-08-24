package org.crispy.yaml.test

import io.swagger.parser.OpenAPIParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.openapitools.openapidiff.core.OpenApiCompare
import org.openapitools.openapidiff.core.output.MarkdownRender

class Openapi3ParserTest {
    @Test
    fun testOpenapiCompare() {
        val parser = OpenAPIParser()
        val target = parser.readLocation(getUrlForResource("v3-petstore.yaml"), null, null).let { result ->
            assertTrue(result.messages.isEmpty())
            assertEquals("3.0.2", result.openAPI.openapi)
            result.openAPI
        }
        val source = parser.readLocation(getUrlForResource("v2-petstore.yaml"), null, null).let { result ->
            assertTrue(result.messages.isEmpty())
            assertEquals("3.0.1", result.openAPI.openapi)
            result.openAPI
        }

        val diff = OpenApiCompare.fromSpecifications(source, target)
        println("Differences:\n${MarkdownRender().render(diff)}")
    }

    private fun getUrlForResource(resourceName: String) =
        Thread.currentThread().contextClassLoader.getResource(resourceName)?.toString()
}