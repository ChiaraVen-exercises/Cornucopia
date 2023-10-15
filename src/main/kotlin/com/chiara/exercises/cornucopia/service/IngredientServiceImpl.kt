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
        TODO("Not yet implemented")
    }

    override fun findAllIngredients(): List<Ingredient> {
        TODO("Not yet implemented")
    }

    override fun saveIngredient(ingredient: Ingredient): Long {
        TODO("Not yet implemented")
    }

    override fun updateIngredientById(id: Long, ingredient: Ingredient): Ingredient {
        TODO("Not yet implemented")
    }

    override fun deleteIngredientById(id: Long): Ingredient {
        TODO("Not yet implemented")
    }

    override fun findIngredientByName(name: String): Ingredient {
        TODO("Not yet implemented")
    }
}
