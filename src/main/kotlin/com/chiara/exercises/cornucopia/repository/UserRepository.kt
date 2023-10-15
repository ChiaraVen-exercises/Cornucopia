package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
