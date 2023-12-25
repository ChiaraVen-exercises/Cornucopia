package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Ingredient

interface IngredientService {

    fun findIngredientsWithNameContaining(name : String) : List<Ingredient>

    fun findIngredientByExactName(name: String): Ingredient

    fun findAllIngredientsSortAscending() : List<Ingredient>
}
