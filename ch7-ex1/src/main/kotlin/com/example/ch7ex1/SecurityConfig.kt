package com.example.ch7ex1

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.formLogin()
    http.authorizeRequests()
      .anyRequest().hasAuthority("WRITE")

    return http.build()
  }

  @Bean
  fun userDetailsService(): UserDetailsService {
    val manager = InMemoryUserDetailsManager()

    val user1 = User.withUsername("chan")
      .password("1234")
      .authorities("READ")
      .build()
    val user2 = User.withUsername("woo")
      .password("1234")
      .authorities("WRITE")
      .build()

    manager.createUser(user1)
    manager.createUser(user2)

    return manager
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return NoOpPasswordEncoder.getInstance()
  }
}