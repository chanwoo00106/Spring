package com.example.ch6ex1.global.security.user

import com.example.ch6ex1.domain.user.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService (
  val userRepository: UserRepository
): UserDetailsService {

  override fun loadUserByUsername(username: String): CustomUserDetails {
    val user = userRepository.findUserByUsername(username)
      ?: throw UsernameNotFoundException("Problem during authentication!")

    return CustomUserDetails(user)
  }
}