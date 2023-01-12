package com.example.ch11ex1s1.domain.otp

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Otp (
  @Id
  @Column(length = 45)
  val username: String,

  @Column(length = 45)
  val code: String
)