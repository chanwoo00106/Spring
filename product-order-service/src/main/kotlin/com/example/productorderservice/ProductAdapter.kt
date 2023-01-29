package com.example.productorderservice

class ProductAdapter (
  private val productRepository: ProductRepository
): ProductPort {
  override fun save(product: Product) {
    productRepository.save(product)
  }
}
