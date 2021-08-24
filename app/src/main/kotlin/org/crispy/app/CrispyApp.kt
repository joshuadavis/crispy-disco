package org.crispy.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CrispyApp

fun main(args: Array<String>) {
    runApplication<CrispyApp>(*args)
}
