package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.service.IngredientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ingredient")
@RestController
class IngredientController (
    val ingredientService : IngredientService
){
    @GetMapping("/all")
    fun getAllIngredients() = ingredientService.findAllIngredients()

    @GetMapping("/{id}")
    fun getIngredient(@PathVariable id : Long) = ingredientService.findIngredientById(id)

    @PostMapping("/update/{id}")
    fun updateIngredient(@PathVariable id : Long, @RequestBody ingredient: Ingredient) : Ingredient {
        println(ingredient)
        ingredientService.updateIngredientById(id, ingredient)
        return ingredient
    }

    @PostMapping("save")
    fun saveIngredient(@RequestBody ingredient: Ingredient) : Long {
        return ingredientService.saveIngredient(ingredient)
    }
}
