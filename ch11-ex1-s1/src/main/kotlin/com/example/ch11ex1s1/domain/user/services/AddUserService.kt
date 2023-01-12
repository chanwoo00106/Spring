package com.example.ch11ex1s1.domain.user.services

import com.example.ch11ex1s1.domain.user.User
import com.example.ch11ex1s1.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class AddUserService (
  private val passwordEncoder: PasswordEncoder,
  private val userRepository: UserRepository
) {
  fun execute(user: User) {
    val newUser = User(user.username, passwordEncoder.encode(user.password))
    userRepository.save(newUser)
  }
}