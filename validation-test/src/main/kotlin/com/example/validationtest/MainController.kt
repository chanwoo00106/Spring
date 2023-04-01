package com.example.validationtest

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MainController {
  @GetMapping
  fun main(authentication: Authentication): String {
    return "hello world! ${authentication.name}"
  }
}