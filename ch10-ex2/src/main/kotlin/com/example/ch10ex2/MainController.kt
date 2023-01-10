package com.example.ch10ex2

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
  @GetMapping("/main")
  fun main(): String {
    return "main.html"
  }
}