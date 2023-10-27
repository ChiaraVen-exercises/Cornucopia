package com.chiara.exercises.cornucopia.dao

import com.chiara.exercises.cornucopia.entity.Ingredient

interface IngredientDAO {

    fun save(ingredient : Ingredient) : Long?

    fun findById (id : Long) : Ingredient

    fun updateById(ingredient: Ingredient): Ingredient

    fun deleteById(ingredient: Ingredient)
}