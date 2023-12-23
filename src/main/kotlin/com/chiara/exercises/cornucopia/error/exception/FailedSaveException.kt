package com.chiara.exercises.cornucopia.error.exception

import java.lang.Exception

class FailedSaveException(element: Any, exception: Exception) : RuntimeException() {

    override val message: String =
        "The element $element could not be saved because of the following error:" +
            "$exception"
}
