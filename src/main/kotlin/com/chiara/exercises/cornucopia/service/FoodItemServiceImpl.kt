package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.FoodItem
import com.chiara.exercises.cornucopia.repository.FoodItemRepository
import com.chiara.exercises.cornucopia.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FoodItemServiceImpl : FoodItemService {

    lateinit var repository : FoodItemRepository

    @Autowired
    fun setRepo (foodItemRepository: FoodItemRepository) {
        this.repository = foodItemRepository
    }

    override fun findFoodItemById(id: Long): FoodItem {
        TODO("Not yet implemented")
    }

    override fun findAllFoodItems(): List<FoodItem> {
        TODO("Not yet implemented")
    }

    override fun saveFoodItem(foodItem: FoodItem): Long {
        TODO("Not yet implemented")
    }

    override fun updateFoodItemById(id: Long, foodItem: FoodItem): FoodItem {
        TODO("Not yet implemented")
    }

    override fun deleteFoodItemById(id: Long): FoodItem {
        TODO("Not yet implemented")
    }

    override fun findFoodItemByPartOfName(name: String): List<FoodItem> {
        TODO("Not yet implemented")
    }
}
