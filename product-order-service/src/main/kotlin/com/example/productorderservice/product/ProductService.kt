package com.example.productorderservice.product

import org.springframework.stereotype.Component

@Component
class ProductService (
  private val productPort: ProductPort
) {
  fun addProduct(request: AddProductRequest) {
    val product = Product(request.name, request.price, request.discountPolicy)
    productPort.save(product)
  }
}
