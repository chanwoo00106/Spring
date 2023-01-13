package com.example.ch11ex1s2.domain.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/test")
class TestController {
  @GetMapping("/")
  fun test(): String {
    return "test"
  }
}