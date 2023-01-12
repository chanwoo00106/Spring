package com.example.ch11ex1s1.domain.user.repository

import com.example.ch11ex1s1.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {
  fun findUserByUsername(username: String): User?
}