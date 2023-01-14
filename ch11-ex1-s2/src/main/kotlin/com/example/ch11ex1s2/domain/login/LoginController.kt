package com.example.ch11ex1s2.domain.login

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController {
  @GetMapping("/")
  fun login(): String {
    return "Login"
  }
}