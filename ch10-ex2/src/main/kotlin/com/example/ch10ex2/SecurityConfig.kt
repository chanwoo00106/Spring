package com.example.ch10ex2

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
  fun uds(): UserDetailsService {
    val uds = InMemoryUserDetailsManager()

    val u1 = User.withUsername("chan")
      .password("1234")
      .authorities("READ")
      .build()
    uds.createUser(u1)

    return uds
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return NoOpPasswordEncoder.getInstance()
  }

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.authorizeRequests()
      .anyRequest().authenticated()
    http.formLogin()
      .defaultSuccessUrl("/main", true)
    return http.build()
  }
}