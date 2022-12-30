package com.example.ch5ex1.config

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
@Component
class CustomAuthenticationProvider (
  private val userDetailsService: UserDetailsService,
  private val passwordEncoder: PasswordEncoder
): AuthenticationProvider {
  override fun authenticate(authentication: Authentication?): Authentication {

    val username = authentication?.name
    val password = authentication?.credentials.toString()

    val u: UserDetails = userDetailsService.loadUserByUsername(username)

    if (!passwordEncoder.matches(password, u.password)) throw BadCredentialsException("Something went wrong!")

    return UsernamePasswordAuthenticationToken(username, password, u.authorities)
  }

  override fun supports(authentication: Class<*>): Boolean {
    return authentication == UsernamePasswordAuthenticationToken::class.java
  }
}