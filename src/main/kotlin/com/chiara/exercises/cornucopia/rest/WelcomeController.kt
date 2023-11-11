package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.service.IngredientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
    fun getAllIngredients() = ingredientService.findAllIngredients()

    @GetMapping("/ingredient/{id}")
    fun getIngredient(@PathVariable id : Long) = ingredientService.findIngredientById(id)

    @PostMapping("ingredient/update/{id}")
    fun updateIngredient(@PathVariable id : Long, @RequestBody ingredient: Ingredient) {
        println(ingredient)
        ingredientService.updateIngredientById(id, ingredient)
    }

}
