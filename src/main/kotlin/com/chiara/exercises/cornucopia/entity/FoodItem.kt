package com.chiara.exercises.cornucopia.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "food_items")
class FoodItem {


    @Id
    var id: Long = TODO("initialize me")
}