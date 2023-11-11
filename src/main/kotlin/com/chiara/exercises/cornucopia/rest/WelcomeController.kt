package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.service.IngredientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/welcome")
@RestController
class WelcomeController (
    val ingredientService : IngredientService
){

    @GetMapping("/intro")
    fun welcome() = "Welcome to Cornucopia, banquet of dreams, delight of the aggrieved"

    @GetMapping("/ingredients")
    fun ingredients() = ingredientService.findAllIngredients()

}
