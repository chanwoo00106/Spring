package com.example.ex8

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
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
    http.csrf().disable()
    http.httpBasic()

    http.authorizeRequests { http ->
      http.mvcMatchers("/hello").authenticated()
//        .antMatchers("/hello").authenticated() // antMatchers 의 경우 /hello는 막아주지만 /hello/는 막지 않기 때문에 mvcMatchers를 사용하는 걸 권장한다
        .mvcMatchers(HttpMethod.GET, "/hi").authenticated()
        .mvcMatchers(HttpMethod.POST, "/hi").permitAll()
        .mvcMatchers("/chan").hasRole("CHAN")
        .anyRequest().permitAll()
    }

    return http.build()
  }

  @Bean
  fun userDetailsService(): UserDetailsService {
    val userDetailsService = InMemoryUserDetailsManager()

    val user1 = User.withUsername("chan")
      .password("1234")
      .roles("CHAN")
      .build()

    val user2 = User.withUsername("woo")
      .password("1234")
      .roles("WOO")
      .build()

    userDetailsService.createUser(user1)
    userDetailsService.createUser(user2)

    return userDetailsService
  }

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return NoOpPasswordEncoder.getInstance()
  }
}