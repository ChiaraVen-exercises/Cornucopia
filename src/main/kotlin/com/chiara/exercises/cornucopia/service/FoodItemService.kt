package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.FoodItem

interface FoodItemService {

    fun findFoodItemById(id : Long) : FoodItem

    fun findAllFoodItems() : List<FoodItem>

    fun saveFoodItem(foodItem: FoodItem) : Long

    fun updateFoodItemById(id : Long, foodItem : FoodItem) : FoodItem

    fun deleteFoodItemById(id : Long) : FoodItem

    fun findFoodItemByPartOfName(name : String) : List<FoodItem>
}
