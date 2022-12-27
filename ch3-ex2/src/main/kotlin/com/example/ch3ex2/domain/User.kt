package com.example.ch3ex2.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User (
  @Column(length = 45, nullable = false)
  val username: String,
  @Column(nullable = false, length = 45)
  val password: String,
  @Column(nullable = false)
  val enabled: Boolean
) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  val id: Long = 0
}