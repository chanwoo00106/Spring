package com.example.validationtest

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class SecurityConfig {
  @Bean
  fun filterChain(http: HttpSecurity, authenticationEntryPoint: CustomAuthenticationEntryPoint, accessDeniedHandler: AccessDeniedHandler): SecurityFilterChain {
    http
      .authorizeHttpRequests()
      .requestMatchers("/admin").hasRole("ADMIN")
      .anyRequest().authenticated()

    http.httpBasic()
      .and()
      .csrf().disable()

    http.exceptionHandling()
      .authenticationEntryPoint(authenticationEntryPoint)
      .accessDeniedHandler(accessDeniedHandler)

    http.addFilterBefore(ExceptionFilter(), UsernamePasswordAuthenticationFilter::class.java)

    return http.build()
  }

  @Bean
  fun userDetailsService(): UserDetailsService {
    val userDetailsService = InMemoryUserDetailsManager()
    val user = User("123", "123", listOf(Role.ROLE_ADMIN))
    userDetailsService.createUser(user)

    return userDetailsService
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()
}