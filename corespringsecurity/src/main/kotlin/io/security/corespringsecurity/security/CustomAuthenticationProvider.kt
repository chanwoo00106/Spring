package io.security.corespringsecurity.security

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component()
class CustomAuthenticationProvider(
  private val passwordEncoder: PasswordEncoder,
  private val userDetailsService: UserDetailsService
): AuthenticationProvider {
  override fun authenticate(authentication: Authentication?): Authentication {
    val username: String? = authentication?.name
    val password: String = authentication?.credentials as String

    val user = userDetailsService.loadUserByUsername(username)

    if (!passwordEncoder.matches(password, user.password)) throw BadCredentialsException("BadCredentialsException")

    return UsernamePasswordAuthenticationToken(user, null, user.authorities)
  }

  override fun supports(authentication: Class<*>?): Boolean {
    return true
  }
}