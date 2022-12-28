package com.korga.zenlyrus.service

import com.korga.zenlyrus.model.entity.User
import com.korga.zenlyrus.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun addNewUser(username: String, password: String) {
        val newUser = User()
        newUser.username = username
        newUser.password = password
        userRepository.save(newUser)
    }

}