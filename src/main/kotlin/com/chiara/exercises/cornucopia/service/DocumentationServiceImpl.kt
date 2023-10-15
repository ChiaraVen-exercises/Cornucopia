package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.Documentation
import com.chiara.exercises.cornucopia.entity.Ingredient
import com.chiara.exercises.cornucopia.repository.DocumentationRepository
import com.chiara.exercises.cornucopia.repository.IngredientRepository
import com.chiara.exercises.cornucopia.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DocumentationServiceImpl : DocumentationService {

    lateinit var repository : DocumentationRepository

    @Autowired
    fun setRepo (documentationRepository: DocumentationRepository) {
        this.repository = documentationRepository
    }

    override fun findDocumentationById(id: Long): Documentation {
        TODO("Not yet implemented")
    }

    override fun findAllDocumentations(): List<Documentation> {
        TODO("Not yet implemented")
    }

    override fun saveDocumentation(documentation: Documentation): Long {
        TODO("Not yet implemented")
    }

    override fun updateDocumentationById(id: Long, documentation: Documentation): Documentation {
        TODO("Not yet implemented")
    }

    override fun deleteDocumentationById(id: Long): Documentation {
        TODO("Not yet implemented")
    }

}
