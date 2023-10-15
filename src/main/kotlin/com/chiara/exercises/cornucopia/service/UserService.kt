package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.User

interface UserService {

    fun findUserById(id : Long) : User

    fun findAllUsers() : List<User>

    fun saveUser(user: User) : Long

    fun updateUserById(id : Long, user : User) : User

    fun deleteUserById(id : Long) : User

    fun findUserByEmail(name : String) : User
}
