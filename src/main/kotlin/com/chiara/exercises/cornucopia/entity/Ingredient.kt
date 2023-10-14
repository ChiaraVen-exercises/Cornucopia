package com.chiara.exercises.cornucopia.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "ingredients")
class Ingredient(

    @Column(name = "name")
    var name: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @ManyToMany
    @JoinTable(
        name = "fooditems_ingredients",
        joinColumns = [
            JoinColumn(
                name = "ingredient_id",
                referencedColumnName = "id"
            )
        ],
        inverseJoinColumns = [
            JoinColumn(
                name = "food_item_id",
                referencedColumnName = "id"
            )
        ]
    )
    @JsonIgnoreProperties("ingredients")
    var foodItems: Set<FoodItem> = setOf()
) {

}
