package com.chiara.exercises.cornucopia.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "food_lots")
class FoodLot (

    @Column(name = "content_description")
    var contentDescription : String,

    @Column(name = "content_description")
    var status : String,

    @OneToOne
    @Column(name = "content_description")
    var bookedBy : User,

    @OneToOne
    @Column(name = "content_description")
    var donatedBy : User,

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long
) {

}