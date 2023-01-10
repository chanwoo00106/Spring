package com.example.ch10ex1

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CsrfFilter

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.addFilterAfter(CsrfTokenLogger(), CsrfFilter::class.java)
    http.authorizeRequests()
      .anyRequest().permitAll()
    return http.build()
  }
}