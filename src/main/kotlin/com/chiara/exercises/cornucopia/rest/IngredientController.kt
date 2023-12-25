package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.error.exception.ElementNotFoundException
import com.chiara.exercises.cornucopia.error.exception.FailedSaveException
import com.chiara.exercises.cornucopia.service.IngredientService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ingredients")
@RestController
class IngredientController(
    val ingredientService: IngredientService
) {
    @GetMapping("")
    fun getAllIngredients() = ingredientService.findAllIngredients()

    @GetMapping("/{id}")
    fun findIngredient(@PathVariable id: Long) =
        try {
            ingredientService.findIngredientById(id)
        } catch (e: NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "id", id)
        }

    @PutMapping("/{id}")
    fun updateIngredient(@PathVariable id: Long, @RequestBody ingredient: Ingredient): Ingredient =
        try {
            println(ingredient)
            ingredientService.updateIngredientById(id, ingredient)
            ingredient
        } catch (e: NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "id", id)
        }

    @PostMapping("")
    fun saveIngredient(@RequestBody ingredient: Ingredient): Long =
        try {
            ingredientService.saveIngredient(ingredient)!!
        } catch (e: Exception) {
            throw FailedSaveException(ingredient, e)
        }

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

    @DeleteMapping("/{id}")
    fun deleteIngredient(@PathVariable id: Long) =
        try {
            ingredientService.deleteIngredientById(id)
        } catch (e: NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "id", id)
        }
}
