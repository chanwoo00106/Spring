package com.example.productorderservice.product

import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
  private var sequence: Long = 0;
  private val persistence = hashMapOf<Long, Product>()
  fun save(product: Product) {
    product.assignId(sequence++)
    persistence[product.id] = product
  }
}
