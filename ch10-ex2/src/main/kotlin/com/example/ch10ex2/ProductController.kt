package com.example.ch10ex2

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.logging.Logger

@Controller
@RequestMapping("/product")
class ProductController {
  private val logger = Logger.getLogger(ProductController::class.java.name)

  @PostMapping("/add")
  fun add(@RequestParam name: String): String {
    logger.info("Adding product $name")
    return "main.html"
  }
}