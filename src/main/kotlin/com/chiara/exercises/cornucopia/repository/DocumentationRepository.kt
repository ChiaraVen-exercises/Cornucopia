package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.Documentation
import org.springframework.data.repository.CrudRepository

interface DocumentationRepository : CrudRepository<Documentation, Long>