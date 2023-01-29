package com.example.productorderservice.product

import org.springframework.stereotype.Component

@Component
class ProductAdapter (
  private val productRepository: ProductRepository
): ProductPort {
  override fun save(product: Product) {
    productRepository.save(product)
  }
}
