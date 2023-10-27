package com.chiara.exercises.cornucopia.dao

import com.chiara.exercises.cornucopia.entity.Ingredient
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class IngredientDAOImpl (
    @Autowired
    val entityManager: EntityManager
) : IngredientDAO {

    @Transactional
    override fun save(ingredient: Ingredient) : Long? {
        entityManager.persist(ingredient)
        var ingredientId = ingredient.id
        println(ingredientId)
        return ingredientId
    }

    @Transactional
    override fun findById (id : Long) : Ingredient {
        return entityManager.find(Ingredient::class.java, id)
    }

    @Transactional
    override fun updateById (ingredient : Ingredient) : Ingredient {
        return entityManager.merge(ingredient)
    }

    @Transactional
    override fun deleteById(ingredient: Ingredient) {
        entityManager.remove(ingredient)
    }

    //    fun saveIngredients(){
//
//        println("Searching for Tsatziki...")
//        var ingredient = Ingredient("Tsatziki")
//        var ingry2 = Ingredient("Ceci")
//        ingredientDAO.save(ingredient)
//        ingredientDAO.save(ingry2)
//        println("Saved, it seems...")
//    }

}

