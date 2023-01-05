package com.example.ch6ex1.domain.product.presentation

import com.example.ch6ex1.domain.product.Product
import com.example.ch6ex1.domain.product.services.FindAllService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController (
  private val findAllService: FindAllService
) {
  @GetMapping("/main")
  fun main(): MutableList<Product> {
    return findAllService.findAll()
  }
}