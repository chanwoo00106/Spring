package com.example.ch6ex1.domain.product.services

import com.example.ch6ex1.domain.product.Product
import com.example.ch6ex1.domain.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class FindAllService (
  val productRepository: ProductRepository
) {
  fun findAll(): MutableList<Product> {
    return productRepository.findAll()
  }
}