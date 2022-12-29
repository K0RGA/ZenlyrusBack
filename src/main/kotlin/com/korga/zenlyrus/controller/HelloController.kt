package com.korga.zenlyrus.controller

import com.korga.zenlyrus.model.dto.AddNewFriendDTO
import com.korga.zenlyrus.model.dto.UserDTO
import com.korga.zenlyrus.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/user"])
class HelloController (private val userService: UserService) {

    @PostMapping("/addNewUser")
    fun hello(@RequestBody userDTO: UserDTO): ResponseEntity<Any>{
        userService.addNewUser(userDTO.username, userDTO.password)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/getUser")
    fun getUsers(): ResponseEntity<Any>{
        return ResponseEntity.ok(userService.getUsers())
    }

    @PutMapping("/addFriend")
    fun addNewFriend(@RequestBody addNewFriendDTO: AddNewFriendDTO): ResponseEntity<Any>{
        val username = addNewFriendDTO.username
        val friendUsername = addNewFriendDTO.newFriendUsername
        userService.addFriend(username, friendUsername)
        return ResponseEntity.ok().build()
    }
}