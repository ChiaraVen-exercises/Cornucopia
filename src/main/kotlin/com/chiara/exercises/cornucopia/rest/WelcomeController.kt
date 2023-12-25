package com.chiara.exercises.cornucopia.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/welcome")
@RestController
class WelcomeController {

    @GetMapping("/intro")
    fun welcome() = "Welcome to Cornucopia, banquet of dreams..."
}