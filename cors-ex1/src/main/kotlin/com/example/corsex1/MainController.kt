package com.example.corsex1

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController {
  @GetMapping("/")
  fun main(): String {
    return "main.html"
  }

//  @CrossOrigin("http://127.0.0.1:8080", "http://localhost:8080")
  @PostMapping("/test")
  @ResponseBody
  fun test(): HelloDto {
    return HelloDto("hello world")
  }
}