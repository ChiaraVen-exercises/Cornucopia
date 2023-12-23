package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.error.exception.ElementNotFoundException
import com.chiara.exercises.cornucopia.error.exception.FailedSaveException
import com.chiara.exercises.cornucopia.error.response.ElementNotFoundErrorResponse
import com.chiara.exercises.cornucopia.service.IngredientService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RequestMapping("/ingredient")
@RestController
class IngredientController (
    val ingredientService : IngredientService
){
    @GetMapping("/all")
    fun getAllIngredients() = ingredientService.findAllIngredients()

    @GetMapping("/{id}")
    fun findIngredient(@PathVariable id : Long) = ingredientService.findIngredientById(id)

    @PostMapping("/update/{id}")
    fun updateIngredient(@PathVariable id : Long, @RequestBody ingredient: Ingredient) : Ingredient {
        logger.info { "accessed UPDATE" }
        println(ingredient)
        ingredientService.updateIngredientById(id, ingredient)
        return ingredient
    }

    @PostMapping("/save")
    fun saveIngredient(@RequestBody ingredient: Ingredient) : Long {
        logger.info { "accessed SAVE" }
        return try {
            ingredientService.saveIngredient(ingredient)!!
        } catch (e: Exception) {
            throw FailedSaveException(ingredient, e)
        }
    }

    @GetMapping("/find_name_containing/{name}")
    fun findIngredientWithNameContaining(@PathVariable name: String) : List<Ingredient> =
        ingredientService.findIngredientsWithNameContaining(name)

    @GetMapping("/find_exact_name/{name}")
    fun findIngredientByExactName(@PathVariable name: String) : Ingredient =
        try {
            ingredientService.findIngredientByExactName(name)
        } catch (e : NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "name", name)
        }

    @GetMapping("/get_all_sort_ascending")
    fun getAllIngredientsSortAscending() : List<Ingredient> =
        ingredientService.findAllIngredientsSortAscending()

    @ExceptionHandler
    fun handleException(e : ElementNotFoundException): ElementNotFoundErrorResponse {
        logger.info { e.message }
        return ElementNotFoundErrorResponse(System.currentTimeMillis(), e.message, HttpStatus.NOT_FOUND.value())
    }
}
