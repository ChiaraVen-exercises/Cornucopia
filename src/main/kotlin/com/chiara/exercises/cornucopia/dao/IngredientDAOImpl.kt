package com.chiara.exercises.cornucopia.dao

import com.chiara.exercises.cornucopia.entity.Ingredient
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import jakarta.persistence.EntityManager

@Repository
class IngredientDAOImpl(
    @Autowired
    val entityManager: EntityManager
) : IngredientDAO  {

    @Transactional
    override fun save(ingredient: Ingredient) {
        entityManager.persist(ingredient)
    }
}

