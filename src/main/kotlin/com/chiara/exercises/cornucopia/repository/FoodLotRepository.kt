package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.FoodLot
import org.springframework.data.repository.CrudRepository

interface FoodLotRepository : CrudRepository<FoodLot, Long>