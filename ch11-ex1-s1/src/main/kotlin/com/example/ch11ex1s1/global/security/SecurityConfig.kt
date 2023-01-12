package com.example.ch11ex1s1.global.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return NoOpPasswordEncoder.getInstance()
  }

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.csrf().disable()
    http.authorizeRequests()
      .anyRequest().permitAll()
    return http.build()
  }
}