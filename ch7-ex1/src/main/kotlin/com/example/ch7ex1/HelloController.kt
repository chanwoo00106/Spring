package com.example.ch7ex1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
  @GetMapping("/hello")
  fun hello(): String {
    return "Hello!"
  }
}