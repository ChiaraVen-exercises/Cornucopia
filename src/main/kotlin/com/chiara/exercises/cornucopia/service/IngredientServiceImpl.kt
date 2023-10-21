package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.repository.IngredientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IngredientServiceImpl : IngredientService {

    lateinit var repository : IngredientRepository

    @Autowired
    fun setRepo (ingredientRepository: IngredientRepository) {
        this.repository = ingredientRepository
    }

    override fun findIngredientById(id: Long): Ingredient {
        return repository.findById(id).get()
    }

    override fun findAllIngredients(): List<Ingredient> {
        val ingredientIterable = repository.findAll()
        var ingredientList : List<Ingredient> = listOf()
        for (el in ingredientIterable) {
            ingredientList += el
        }
        return ingredientList
    }

    override fun saveIngredient(ingredient: Ingredient): Long? {
        return repository.save(ingredient).id
    }

    override fun updateIngredientById(id: Long, ingredient: Ingredient): Ingredient {
        val updatedIngredient = repository.findById(id).get()
            updatedIngredient.name = ingredient.name
            updatedIngredient.foodItems = ingredient.foodItems
            repository.save(updatedIngredient)
        return updatedIngredient
    }

    override fun deleteIngredientById(id: Long): Ingredient {
        val ingredient = repository.findById(id).get()
        repository.deleteById(id)
        return ingredient
    }

    override fun findIngredientByName(name: String): Ingredient {
        TODO("Not yet implemented")
    }
}
