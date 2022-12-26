package com.workshop.security.config

import com.workshop.security.entity.User
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
class Config {
  @Bean
  fun securityConfig(http: HttpSecurity): SecurityFilterChain {
    http.formLogin()
    http.authorizeRequests()
      .anyRequest().authenticated()

    return http.build()
  }

  @Bean
  fun userDetailsService(): UserDetailsService {
    val userDetailsService = InMemoryUserDetailsService()

    val user = User("chan", "12345", "read")

    userDetailsService.users = mutableListOf(user)

    return userDetailsService
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    // NoOpPasswordEncoder는 사용하면 안됨
    return NoOpPasswordEncoder.getInstance()
  }
}