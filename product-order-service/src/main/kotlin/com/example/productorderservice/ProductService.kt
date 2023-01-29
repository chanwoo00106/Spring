package com.example.productorderservice

class ProductService (
  private val productPort: ProductPort
) {
  fun addProduct(request: AddProductRequest) {
    val product = Product(request.name, request.price, request.discountPolicy)
    productPort.save(product)
  }
}
