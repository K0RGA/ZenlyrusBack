package com.korga.zenlyrus.service

import com.korga.zenlyrus.model.entity.User
import com.korga.zenlyrus.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository) {

    fun addNewUser(username: String, password: String) {
        val newUser = User()
        newUser.username = username
        newUser.password = password
        userRepository.save(newUser)
    }

    fun getUsers(): List<User>{
        val list = userRepository.findAll()
        return list
    }

    fun addFriend(username: String, newFriendUsername: String){
        val user = userRepository.findByUsername(username).orElse(null)
        val friend = userRepository.findByUsername(newFriendUsername).orElse(null)
        if (user == null || friend == null){
            throw RuntimeException("Пользователь не найден")
        }
        user.friendList?.add(friend)
        friend.friendList?.add(user)
        userRepository.save(user)
        userRepository.save(friend)
    }

}