package com.example.ch3ex2.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Authorities (
  @Column(length = 45, nullable = false)
  val username: String,
  @Column(length = 45, nullable = false)
  val authority: String

) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0
}