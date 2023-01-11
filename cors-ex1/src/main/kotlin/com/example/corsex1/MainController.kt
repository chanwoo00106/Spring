package com.example.corsex1

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController {
  @GetMapping("/")
  fun main(): String {
    return "main.html"
  }

  @PostMapping("/test")
  @ResponseBody
  fun test(): String {
    return "Hello"
  }
}