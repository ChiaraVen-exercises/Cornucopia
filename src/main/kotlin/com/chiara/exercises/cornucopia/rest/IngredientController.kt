package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.error.exception.ElementNotFoundException
import com.chiara.exercises.cornucopia.service.IngredientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = ["/ingredients"], produces = ["application/hal+json"])
@RestController
class IngredientController(
    val ingredientService: IngredientService
) {
    @GetMapping("/name_containing/{name}")
    fun findIngredientWithNameContaining(@PathVariable name: String): List<Ingredient> =
        ingredientService.findIngredientsWithNameContaining(name)

    @GetMapping("/exact_name/{name}")
    fun findIngredientByExactName(@PathVariable name: String): Ingredient =
        try {
            ingredientService.findIngredientByExactName(name)
        } catch (e: NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "name", name)
        }

    @GetMapping("/sort_ascending")
    fun getAllIngredientsSortAscending(): List<Ingredient> =
        ingredientService.findAllIngredientsSortAscending()
}
