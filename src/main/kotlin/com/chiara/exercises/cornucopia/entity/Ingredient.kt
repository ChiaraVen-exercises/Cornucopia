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
    var id: Int
) {

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
    @JsonIgnoreProperties
    var foodItems: Set<FoodItem> = setOf()

    override fun toString(): String {
        return "Ingredient(id=$id, name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ingredient

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}
