package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.FoodLot

interface FoodLotService {

    fun findFoodLotById(id : Long) : FoodLot

    fun findAllFoodLots() : List<FoodLot>

    fun saveFoodLot(foodLot: FoodLot) : Long

    fun updateFoodLotById(id : Long, foodLot : FoodLot) : FoodLot

    fun deleteFoodLotById(id : Long) : FoodLot
}
