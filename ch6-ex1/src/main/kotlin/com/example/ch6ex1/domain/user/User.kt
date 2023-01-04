package com.example.ch6ex1.domain.user

import com.example.ch6ex1.domain.authority.Authority
import com.example.ch6ex1.domain.user.enums.Algorithm
import javax.persistence.*

@Entity
class User (
  @Column(nullable = false, length = 45)
  val username: String,

  @Column(nullable = false)
  val password: String,

  @Enumerated(EnumType.STRING)
  val algorithm: Algorithm,

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  val authorities: MutableList<Authority> = mutableListOf()
) {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0
}