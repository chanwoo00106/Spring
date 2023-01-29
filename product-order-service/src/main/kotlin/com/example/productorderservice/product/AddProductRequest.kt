package com.example.productorderservice.product

data class AddProductRequest(
  val name: String,
  val price: Int,
  val discountPolicy: DiscountPolicy
)
