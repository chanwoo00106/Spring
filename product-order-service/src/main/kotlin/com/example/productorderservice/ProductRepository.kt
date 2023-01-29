package com.example.productorderservice

class ProductRepository {
  private var sequence: Long = 0;
  private val persistence = hashMapOf<Long, Product>()
  fun save(product: Product) {
    product.assignId(sequence++)
    persistence[product.id] = product
  }
}
