package com.chiara.exercises.cornucopia.runner

import com.chiara.exercises.cornucopia.dao.IngredientDAOImpl
import com.chiara.exercises.cornucopia.entity.Ingredient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class IngredientDAOSupport (

    @Autowired
    var ingredientDAO :  IngredientDAOImpl

){
    fun saveIngredients(){

        println("Saving Tsatziki...")
        var ingredient = Ingredient("Tsatziki")
        var ingry2 = Ingredient("Ceci")
        ingredientDAO.save(ingredient)
        ingredientDAO.save(ingry2)
        println("Saved, it seems...")
    }
}
