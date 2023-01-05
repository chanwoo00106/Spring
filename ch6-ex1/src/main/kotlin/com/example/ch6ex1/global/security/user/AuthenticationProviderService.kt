package com.example.ch6ex1.global.security.user

import com.example.ch6ex1.domain.user.enums.Algorithm
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationProviderService (
  private val userDetailsService: CustomUserDetailsService,
  private val bCryptPasswordEncoder: BCryptPasswordEncoder,
  private val sCryptPasswordEncoder: SCryptPasswordEncoder
): AuthenticationProvider {
  override fun authenticate(authentication: Authentication): Authentication {
    val username = authentication.name
    val password = authentication.credentials.toString()

    val user = userDetailsService.loadUserByUsername(username)

    return when (user.user.algorithm) {
      Algorithm.BCRYPT -> checkPassword(user, password, bCryptPasswordEncoder)
      Algorithm.SCRYPT -> checkPassword(user, password, sCryptPasswordEncoder)
    }
  }
  override fun supports(authentication: Class<*>): Boolean {
    return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
  }


  private fun checkPassword (
    user: CustomUserDetails,
    password: String,
    encoder: PasswordEncoder
  ): Authentication {
    if (encoder.matches(password, user.password)) {
      return UsernamePasswordAuthenticationToken(user.username, user.password, user.authorities)
    }

    throw BadCredentialsException("Bad credentials")
  }

}