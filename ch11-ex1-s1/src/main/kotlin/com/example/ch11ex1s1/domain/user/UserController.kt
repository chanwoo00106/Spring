package com.example.ch11ex1s1.domain.user

import com.example.ch11ex1s1.domain.user.services.AddUserService
import com.example.ch11ex1s1.domain.user.services.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
  private val addUserService: AddUserService,
  private val authService: AuthService
) {
  @PostMapping("/add")
  fun addUser(@RequestBody user: User) {
    addUserService.execute(user)
  }

  @PostMapping("/auth")
  fun auth(@RequestBody user: User) {
    authService.execute(user)
  }
}