package com.example.productorderservice.product

import com.example.productorderservice.*
import org.junit.jupiter.api.Test

class ProductServiceTest() {
  private val productRepository = ProductRepository()
  private val productPort: ProductPort = ProductAdapter(productRepository)
  private val productService: ProductService = ProductService(productPort)

  @Test
  fun 상품등록() {
    val request = 상품등록요청_생성()
    productService.addProduct(request)
  }

  fun 상품등록요청_생성(): AddProductRequest {
    val name = "상품명"
    val price = 1000
    val discountPolicy = DiscountPolicy.NONE
    return AddProductRequest(name, price, discountPolicy)
  }
}


