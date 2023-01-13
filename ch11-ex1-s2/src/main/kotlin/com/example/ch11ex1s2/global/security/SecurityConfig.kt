package com.example.ch11ex1s2.global.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.web.client.RestTemplate

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun restTemplate(): RestTemplate {
    return RestTemplate()
  }
}