package org.crispy.app

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ContextLoadingTest {
    @Test
    fun contextLoads() {
        assertTrue(true)
    }
}
