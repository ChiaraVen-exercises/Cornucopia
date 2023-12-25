package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.FoodItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "food_items")
interface FoodItemRepository : JpaRepository<FoodItem, Long>