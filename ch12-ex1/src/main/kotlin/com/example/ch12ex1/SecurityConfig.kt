package com.example.ch12ex1

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {
  @Value("\${oauth.clientId}")
 val clientId: String = ""

  @Value("\${oauth.clientSecret}")
  val clientSecret: String = ""

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    http.oauth2Login()
    http.authorizeRequests()
      .anyRequest().authenticated()
    return http.build()
  }

  @Bean
  fun clientRegistration(): ClientRegistration {
    return CommonOAuth2Provider.GITHUB
      .getBuilder("github")
      .clientId(clientId)
      .clientSecret(clientSecret)
      .build()
  }

  @Bean
  fun clientRepository(): ClientRegistrationRepository {
    val c = clientRegistration()
    return InMemoryClientRegistrationRepository(c)
  }
}