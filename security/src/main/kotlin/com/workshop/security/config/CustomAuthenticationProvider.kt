package com.workshop.security.config

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationProvider: AuthenticationProvider {
  override fun authenticate(authentication: Authentication): Authentication {
    val username = authentication.name
    val password = authentication.credentials.toString()

    if (username != "chan" || password != "1234") throw AuthenticationCredentialsNotFoundException("Error!")

    return UsernamePasswordAuthenticationToken(username, password, listOf())
  }

  override fun supports(authentication: Class<*>): Boolean {
      return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
  }
}