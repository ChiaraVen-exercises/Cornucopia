package com.chiara.exercises.cornucopia.runner

import com.chiara.exercises.cornucopia.dao.IngredientDAO
import com.chiara.exercises.cornucopia.dao.IngredientDAOImpl
import com.chiara.exercises.cornucopia.entity.Ingredient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(3)
class IngredientDAOSupport (

    @Autowired
    var ingredientDAO :  IngredientDAOImpl

){
    fun saveIngredient(){
    // BE CAREFUL! NOARGS IS NOT WORKING! YOU NEED TO UNDERSTAND WHY.
        println("Saving Tsatziki...")
        var ingredient = Ingredient("Tsatziki", 100)
        ingredientDAO.save(ingredient)
        println("Saved, it seems...")
    }
}
