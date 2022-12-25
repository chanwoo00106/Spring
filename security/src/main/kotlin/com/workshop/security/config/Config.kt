package com.workshop.security.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource


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
    val userDetailsService = InMemoryUserDetailsManager()

    val user = User.withUsername("user")
      .password("1234")
      .authorities("read")
      .build()
    userDetailsService.createUser(user)

    return userDetailsService
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    // NoOpPasswordEncoder는 사용하면 안됨
    return NoOpPasswordEncoder.getInstance()
  }
}