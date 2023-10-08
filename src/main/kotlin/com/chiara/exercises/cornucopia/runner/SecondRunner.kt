package com.chiara.exercises.cornucopia.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class SecondRunner : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("We serve cakes made of roses, fried paste of lilies...")
    }
}
