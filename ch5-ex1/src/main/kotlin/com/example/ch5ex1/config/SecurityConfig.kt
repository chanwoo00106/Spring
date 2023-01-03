package com.example.ch5ex1.config

import com.example.ch5ex1.CustomEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component


@Component
@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.httpBasic { c ->
      c.realmName("Hello")
        .authenticationEntryPoint(CustomEntryPoint())
    }

    http.authorizeHttpRequests { h ->
      h.anyRequest().authenticated()
    }
    return http.build()
  }
  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return NoOpPasswordEncoder.getInstance()
  }

  @Bean
  fun userDetailsService(): UserDetailsService {
    val userDetailsService = InMemoryUserDetailsManager()

    val user = User("chan", "1234", mutableListOf())
    userDetailsService.createUser(user)

    return userDetailsService
  }
}