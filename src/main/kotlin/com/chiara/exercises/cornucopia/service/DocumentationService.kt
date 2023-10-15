package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Documentation
import com.chiara.exercises.cornucopia.entity.Ingredient

interface DocumentationService {

    fun findDocumentationById(id : Long) : Documentation

    fun findAllDocumentations() : List<Documentation>

    fun saveDocumentation(documentation: Documentation) : Long

    fun updateDocumentationById(id : Long, documentation : Documentation) : Documentation

    fun deleteDocumentationById(id : Long) : Documentation

}
