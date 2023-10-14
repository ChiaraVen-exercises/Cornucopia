package com.chiara.exercises.cornucopia.runner

import com.chiara.exercises.cornucopia.dao.IngredientDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class SecondRunner : CommandLineRunner {

    lateinit var sup : IngredientDAOSupport

    @Autowired
    fun setSup(ingredientDAO : IngredientDAO) {
        this.sup = sup
    }

    override fun run(vararg args: String?) {
        println("We serve cakes made of roses, fried paste of lilies...")
        sup.saveIngredient()
    }
}
