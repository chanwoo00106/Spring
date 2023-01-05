package com.example.ch6ex1.global.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Bean
  fun sCryptPasswordEncoder(): SCryptPasswordEncoder {
    return SCryptPasswordEncoder()
  }
}