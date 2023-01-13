package com.example.ch11ex1s2.global.security.provider

import com.example.ch11ex1s2.global.security.auth.OtpAuthentication
import com.example.ch11ex1s2.global.security.proxy.AuthenticationServerProxy
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class OtpAuthenticationProvider(
  private val proxy: AuthenticationServerProxy
): AuthenticationProvider {
  override fun authenticate(authentication: Authentication?): Authentication {
    val username = authentication?.name.toString()
    val code = authentication?.credentials.toString()

    val result = proxy.sendOTP(username, code)

    if (!result) throw BadCredentialsException("Bad credentials")

    return OtpAuthentication(username, code)
  }

  override fun supports(authentication: Class<*>): Boolean {
    return OtpAuthentication::class.java.isAssignableFrom(authentication)
  }
}