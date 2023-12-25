package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.FoodItem
import org.springframework.data.jpa.repository.JpaRepository

//@RepositoryRestResource(path = "food_items")
interface FoodItemRepository : JpaRepository<FoodItem, Long>