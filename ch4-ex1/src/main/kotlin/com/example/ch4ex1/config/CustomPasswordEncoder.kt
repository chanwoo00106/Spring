package com.example.ch4ex1.config

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class CustomPasswordEncoder: PasswordEncoder {
  override fun encode(rawPassword: CharSequence): String {
    return rawPassword.toString()
  }

  override fun matches(rawPassword: CharSequence, encodedPassword: String): Boolean {
    return rawPassword == encodedPassword
  }
}
