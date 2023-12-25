package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.FoodLot
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "food_lots")
interface FoodLotRepository : CrudRepository<FoodLot, Long>