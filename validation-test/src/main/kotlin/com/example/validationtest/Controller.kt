package com.example.validationtest

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class Controller {
  @PostMapping
  fun hello(@RequestBody @Valid body: Test): String {
    return "Hello"
  }

  @PostMapping("/test")
  fun hi(@RequestBody @Valid body: Test): String {
    return "hi"
  }
}