package com.example.ch6ex1.domain.authority

import com.example.ch6ex1.domain.user.User
import javax.persistence.*

@Entity
class Authority (
  @Column(nullable = false, length = 45)
  val name: String,

  @JoinColumn(name = "user")
  @ManyToOne
  val user: User
) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0
}