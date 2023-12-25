package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.Documentation
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentationRepository : JpaRepository<Documentation, Long>