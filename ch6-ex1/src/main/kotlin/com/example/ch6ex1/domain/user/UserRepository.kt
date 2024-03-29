package com.example.ch6ex1.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
  fun findUserByUsername(username: String): User?
}