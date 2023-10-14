package com.chiara.exercises.cornucopia.dao

import com.chiara.exercises.cornucopia.entity.Ingredient

interface IngredientDAO {

    fun save(ingredient : Ingredient)

}