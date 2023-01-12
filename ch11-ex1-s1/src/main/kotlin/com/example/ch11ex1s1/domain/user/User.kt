package com.example.ch11ex1s1.domain.user

import javax.persistence.*

@Entity
class User (
  @Id
  @Column(length = 45)
  val username: String,
  @Column(nullable = false)
  val password: String
)