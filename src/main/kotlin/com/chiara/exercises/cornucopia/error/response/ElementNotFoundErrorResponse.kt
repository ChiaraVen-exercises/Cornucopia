package com.chiara.exercises.cornucopia.error.response

class ElementNotFoundErrorResponse(
    val timestamp : Long = 0,
    val message : String,
    val status : Int
)