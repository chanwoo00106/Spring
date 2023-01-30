package com.example.productorderservice.product

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductService (
  private val productPort: ProductPort
) {
  @PostMapping
  fun addProduct(@RequestBody request: AddProductRequest): ResponseEntity<Void> {
    val product = Product(request.name, request.price, request.discountPolicy)
    productPort.save(product)
    return ResponseEntity.status(HttpStatus.CREATED).build()
  }
}
