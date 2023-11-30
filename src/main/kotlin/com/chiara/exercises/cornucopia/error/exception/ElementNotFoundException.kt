package com.chiara.exercises.cornucopia.error.exception

class ElementNotFoundException(element: String, id: Long) : RuntimeException() {

    override val message: String =
        "No entries on the database could be found for $element with id of $id."
}
