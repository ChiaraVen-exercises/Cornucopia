package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Ingredient

interface IngredientService {

    fun findIngredientById(id : Long) : Ingredient

    fun findAllIngredients() : List<Ingredient>

    fun saveIngredient(ingredient: Ingredient) : Long?

    fun updateIngredientById(id : Long, ingredient : Ingredient) : Ingredient

    fun deleteIngredientById(id : Long) : Ingredient

    fun findIngredientByName(name : String) : Ingredient
}