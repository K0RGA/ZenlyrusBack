package com.korga.zenlyrus.controller

import com.korga.zenlyrus.model.dto.UserDTO
import com.korga.zenlyrus.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class HelloController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/addNewUser")
    fun hello(@RequestBody userDTO: UserDTO): ResponseEntity<Any>{
        userService.addNewUser(userDTO.username, userDTO.password)
        return ResponseEntity.ok().build()
    }
}