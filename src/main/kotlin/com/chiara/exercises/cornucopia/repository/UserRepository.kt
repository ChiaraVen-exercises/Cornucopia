package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
