package com.workshop.security.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/greetings")
class GreetingsController {
  @GetMapping
  fun sayHello(): ResponseEntity<String> {
    return ResponseEntity.ok("hello world")
  }

  @GetMapping("good-bye")
  fun sayGoodBye(): ResponseEntity<String> {
    return ResponseEntity.ok("Good bye")
  }
}