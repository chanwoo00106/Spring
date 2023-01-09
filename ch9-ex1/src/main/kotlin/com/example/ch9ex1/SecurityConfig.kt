package com.example.ch9ex1

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@EnableWebSecurity
class SecurityConfig {
  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.httpBasic().and()
    .addFilterBefore(RequestValidationFilter(), BasicAuthenticationFilter::class.java)
      .addFilterAfter(AuthenticationLoggingFilter(), BasicAuthenticationFilter::class.java)
    .authorizeRequests()
      .anyRequest().permitAll()

    return http.build()
  }
}