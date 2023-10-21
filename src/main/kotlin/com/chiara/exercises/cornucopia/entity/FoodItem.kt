package com.chiara.exercises.cornucopia.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "food_items")
class FoodItem (

    @Column(name = "description")
    var description : String,

    @Column(name = "expiration_date")
    var expirationDate : Date,

    @Column(name = "category")
    var category : String,

    @Column(name = "traceableCode")
    var traceableCode : Long,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "lot_id", referencedColumnName = "id")
//    @JsonIgnoreProperties("food_items")
//    var lotId : FoodLot,

    @ManyToMany(mappedBy = "foodItems")
    @JsonIgnoreProperties("food_items")
    var ingredients : Set<Ingredient> = mutableSetOf()
){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Long? = null

}
