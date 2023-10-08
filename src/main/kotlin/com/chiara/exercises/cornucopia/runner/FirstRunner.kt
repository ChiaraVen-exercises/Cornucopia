package com.chiara.exercises.cornucopia.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
// The annotation @Order establishes the order in which the runners will be invoked.
@Order(1)
class FirstRunner : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Welcome to the banquet of Redwall.")
    }
}
