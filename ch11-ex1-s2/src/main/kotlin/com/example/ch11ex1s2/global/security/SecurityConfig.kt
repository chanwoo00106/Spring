package com.example.ch11ex1s2.global.security

import com.example.ch11ex1s2.global.security.filter.InitialAuthenticationFilter
import com.example.ch11ex1s2.global.security.filter.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.web.client.RestTemplate

@EnableWebSecurity
class SecurityConfig (
  private val initialAuthenticationFilter: InitialAuthenticationFilter,
  private val jwtAuthenticationFilter: JwtAuthenticationFilter,
) {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.csrf().disable()
    http.addFilterAt(initialAuthenticationFilter, BasicAuthenticationFilter::class.java)
      .addFilterAfter(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)

    http.authorizeRequests()
      .anyRequest().authenticated()
    return http.build()
  }

  @Bean
  fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
    return authenticationConfiguration.authenticationManager
  }

  @Bean
  fun restTemplate(): RestTemplate {
    return RestTemplate()
  }
}