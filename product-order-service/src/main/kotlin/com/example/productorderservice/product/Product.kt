package com.example.productorderservice.product
class Product(
  val name: String,
  val price: Int,
  val discountPolicy: DiscountPolicy
) {
  var id: Long = 0
  fun assignId(aLong: Long) {
    id = aLong
  }
}
