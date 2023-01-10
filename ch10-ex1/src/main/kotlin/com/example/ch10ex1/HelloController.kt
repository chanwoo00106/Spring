package com.example.ch10ex1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
  @GetMapping("/hello")
  fun getHello(): String {
    return "Get Hello!"
  }

  @PostMapping("/hello")
  fun postHello(): String {
    return "Post Hello!"
  }
}