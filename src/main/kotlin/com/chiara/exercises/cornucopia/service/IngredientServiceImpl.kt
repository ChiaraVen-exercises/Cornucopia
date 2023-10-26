package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.repository.IngredientRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.NoSuchElementException

@Service
class IngredientServiceImpl : IngredientService {

    lateinit var repository : IngredientRepository

    @Autowired
    fun setRepo (ingredientRepository: IngredientRepository) {
        this.repository = ingredientRepository
    }

    @Transactional
    override fun findIngredientById(id: Long): Ingredient {
        return repository.findById(id).get()
    }

    @Transactional
    override fun findAllIngredients(): List<Ingredient> {
        val ingredientIterable = repository.findAll()
        var ingredientList : List<Ingredient> = listOf()
        for (el in ingredientIterable) {
            ingredientList += el
        }
        return ingredientList
    }

    @Transactional
    override fun saveIngredient(ingredient: Ingredient): Long? {
        return repository.save(ingredient).id
    }

    @Transactional
    override fun updateIngredientById(id: Long, ingredient: Ingredient): Ingredient {
        val updatedIngredient = repository.findById(id).get()
            updatedIngredient.name = ingredient.name
            updatedIngredient.foodItems = ingredient.foodItems
            repository.save(updatedIngredient)
        return updatedIngredient
    }

    @Transactional
    override fun deleteIngredientById(id: Long): Ingredient {
        val ingredient = repository.findById(id).get()
        repository.deleteById(id)
        return ingredient
    }

    @Transactional
    override fun findIngredientsWithNameContaining(name: String) : List<Ingredient> {
        return repository.getIngredientsWithNameContaining(name).toList()
    }

    @Transactional
    override fun findIngredientByExactName(name: String): Ingredient {
        val ingredientsWithExactName = repository.getIngredientByExactName(name).toList()
        when {
            // add logic for logging / storing a warning about multiple ingredients with same name
            ingredientsWithExactName.size > 1 ->
                println("There's a problem. The database contains at least two ingredients with the name '$name'!")
            // establish a common message for all the NoSuchElementExceptions in the app
            ingredientsWithExactName.isEmpty() -> throw NoSuchElementException("No elements matching your search could be found.")
        }
        return ingredientsWithExactName[0]
    }

    @Transactional
    override fun findAllIngredientsSortAscending(): List<Ingredient> {
        return repository.getAllIngredientsSortedByNameAsc().toList()
    }
}
