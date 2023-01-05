package com.example.ch6ex1.domain.product

import com.example.ch6ex1.domain.product.enums.Currency
import javax.persistence.*

@Entity
class Product (
  @Column(nullable = false, length = 45)
  val name: String,

  @Column(nullable = false, length = 45)
  val price: Int,

  @Enumerated(value = EnumType.STRING)
  val currency: Currency
) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0
}