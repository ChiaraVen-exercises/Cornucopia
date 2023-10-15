package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.FoodItem
import org.springframework.data.repository.CrudRepository

interface FoodItemRepository : CrudRepository<FoodItem, Long>