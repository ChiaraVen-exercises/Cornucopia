package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.Ingredient
import org.springframework.data.repository.CrudRepository

interface IngredientRepository : CrudRepository<Ingredient, Long>
