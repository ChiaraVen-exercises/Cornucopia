package com.chiara.exercises.cornucopia.runner

import com.chiara.exercises.cornucopia.service.IngredientServiceImpl
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class SecondRunner : CommandLineRunner {

    lateinit var ingredientServiceImpl : IngredientServiceImpl

    @Autowired
    fun setIngredientServiceImplementation(ingredientServiceImpl: IngredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl
    }

    // added this annotation to avoid a LazyInitializationException.
    // this way, the info for the set of food items (lazily fetched) which contain the ingredient
    // is fetched while the Hibernate session created for the retrieval is still open
    // (changing the fetch type of the set of food items to eager would also avoid
    // this issue, but it is considered an anti-pattern.
    @Transactional
    override fun run(vararg args: String?) {
        println("We serve cakes made of roses, fried paste of lilies...")

        val list = ingredientServiceImpl.findAllIngredients()
        for (el in list) {
            println(el)
        }
    }
}
