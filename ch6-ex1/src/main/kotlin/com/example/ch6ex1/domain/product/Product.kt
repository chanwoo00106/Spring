package com.example.ch6ex1.domain.product

import javax.persistence.*

@Entity
class Product (
  @Column(nullable = false, length = 45)
  val name: String,

  @Column(nullable = false, length = 45)
  val price: Int,

  @Column(nullable = false, length = 45)
  val currency: String
) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0
}