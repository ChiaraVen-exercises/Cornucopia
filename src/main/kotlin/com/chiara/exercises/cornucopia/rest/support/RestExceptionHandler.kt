package com.chiara.exercises.cornucopia.rest.support

import com.chiara.exercises.cornucopia.error.exception.ElementNotFoundException
import com.chiara.exercises.cornucopia.error.exception.FailedSaveException
import com.chiara.exercises.cornucopia.error.response.ElementNotFoundResponse
import com.chiara.exercises.cornucopia.error.response.FailedSaveResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

private val logger = KotlinLogging.logger {}

@ControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler
    fun handleElementNotFoundException(e : ElementNotFoundException): ResponseEntity<ElementNotFoundResponse> {
        logger.info { e.message }
        val response = ElementNotFoundResponse(System.currentTimeMillis(), e.message, HttpStatus.NOT_FOUND.value())
        return ResponseEntity(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleFailedSaveException(e : FailedSaveException) : ResponseEntity<FailedSaveResponse> {
        logger.info { e.message }
        val response = FailedSaveResponse(System.currentTimeMillis(), e.message, HttpStatus.INTERNAL_SERVER_ERROR.value())
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}