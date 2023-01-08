package com.example.ex8

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
  @GetMapping("/hello")
  fun hello(): String {
    return "Hello!"
  }

  @GetMapping("/hi")
  fun hi(auth: Authentication): String {
    return auth.name + " Hi"
  }

  @PostMapping("/hi")
  fun hi(): String {
    return "Hi"
  }

  @GetMapping("/chan")
  fun chan(): String {
    return "Hello! chan"
  }
}