package com.example.productorderservice

data class AddProductRequest(
  val name: String,
  val price: Int,
  val discountPolicy: DiscountPolicy
) {
}
