package com.chiara.exercises.cornucopia.error.exception

class ElementNotFoundException(element: String, searchParameterKey : String, searchParameterValue : Any) : RuntimeException() {

    override val message: String =
        "No entries on the database could be found for the $element with $searchParameterKey " +
            "= $searchParameterValue."
}
