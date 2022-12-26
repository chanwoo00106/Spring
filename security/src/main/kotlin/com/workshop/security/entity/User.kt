package com.workshop.security.entity

import javax.persistence.*

@Entity
class User (
  val username: String,
  val password: String,
  val authority: String
) {
  @Id
  @GeneratedValue
  val id: Long = 0
}