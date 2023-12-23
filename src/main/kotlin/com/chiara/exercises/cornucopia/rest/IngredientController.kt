package com.chiara.exercises.cornucopia.rest

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.error.exception.ElementNotFoundException
import com.chiara.exercises.cornucopia.error.exception.FailedSaveException
import com.chiara.exercises.cornucopia.error.response.ElementNotFoundResponse
import com.chiara.exercises.cornucopia.error.response.FailedSaveResponse
import com.chiara.exercises.cornucopia.service.IngredientService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun findIngredient(@PathVariable id : Long) {
        try {
            ingredientService.findIngredientById(id)
        } catch (e : NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "id", id)
        }
    }

    @PostMapping("/update/{id}")
    fun updateIngredient(@PathVariable id : Long, @RequestBody ingredient: Ingredient) : Ingredient {
        return try {
            logger.info { "accessed UPDATE" }
            println(ingredient)
            ingredientService.updateIngredientById(id, ingredient)
            ingredient
        } catch (e : NoSuchElementException) {
            throw ElementNotFoundException("ingredient", "id", id)
        }
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
    fun handleElementNotFoundException(e : ElementNotFoundException): ResponseEntity<ElementNotFoundResponse> {
        logger.info { e.message }
        val response = ElementNotFoundResponse(System.currentTimeMillis(), e.message, HttpStatus.NOT_FOUND.value())
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleFailedSaveException(e : FailedSaveException) : ResponseEntity<FailedSaveResponse> {
        logger.info { e.message }
        val response = FailedSaveResponse(System.currentTimeMillis(), e.message, HttpStatus.INTERNAL_SERVER_ERROR.value())
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
