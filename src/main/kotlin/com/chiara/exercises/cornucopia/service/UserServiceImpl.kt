package com.chiara.exercises.cornucopia.service

import com.chiara.exercises.cornucopia.entity.User
import com.chiara.exercises.cornucopia.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    lateinit var repository : UserRepository

    @Autowired
    fun setRepo (userRepository: UserRepository) {
        this.repository = userRepository
    }

    override fun findUserById(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun findAllUsers(): List<User> {
        TODO("Not yet implemented")
    }

    override fun saveUser(user: User): Long {
        TODO("Not yet implemented")
    }

    override fun updateUserById(id: Long, user: User): User {
        TODO("Not yet implemented")
    }

    override fun deleteUserById(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun findUserByEmail(name: String): User {
        TODO("Not yet implemented")
    }
}
