package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.FoodLot
import com.chiara.exercises.cornucopia.repository.FoodLotRepository
import com.chiara.exercises.cornucopia.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FoodLotServiceImpl : FoodLotService {

    lateinit var repository : FoodLotRepository

    @Autowired
    fun setRepo (foodLotRepository: FoodLotRepository) {
        this.repository = foodLotRepository
    }

    override fun findFoodLotById(id: Long): FoodLot {
        TODO("Not yet implemented")
    }

    override fun findAllFoodLots(): List<FoodLot> {
        TODO("Not yet implemented")
    }

    override fun saveFoodLot(foodLot: FoodLot): Long {
        TODO("Not yet implemented")
    }

    override fun updateFoodLotById(id: Long, foodLot: FoodLot): FoodLot {
        TODO("Not yet implemented")
    }

    override fun deleteFoodLotById(id: Long): FoodLot {
        TODO("Not yet implemented")
    }
}
