package com.example.ch11ex1s2.global.security.auth

import com.example.ch11ex1s2.global.security.provider.OtpAuthenticationProvider
import com.example.ch11ex1s2.global.security.provider.UsernamePasswordAuthenticationProvider
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationManager (
  private val otpAuthenticationProvider: OtpAuthenticationProvider,
  private val usernamePasswordAuthenticationProvider: UsernamePasswordAuthenticationProvider
): AuthenticationManager {
  override fun authenticate(authentication: Authentication): Authentication? {
    if (otpAuthenticationProvider.supports(authentication::class.java))
      return otpAuthenticationProvider.authenticate(authentication)
    else if (usernamePasswordAuthenticationProvider.supports(authentication::class.java))
      return usernamePasswordAuthenticationProvider.authenticate(authentication)

    throw BadCredentialsException("not support authentication")
  }
}