package com.example.ch11ex1s2.global.security.proxy

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class AuthenticationServerProxy (
  private val rest: RestTemplate
) {
  @Value("\${auth.server.base.url}")
  private val baseUrl: String = ""

  fun sendAuth(username: String, password: String) {
    val url = "$baseUrl/user/auth"

    val body = UserDto(username, password)

    val request = HttpEntity(body)
    rest.postForEntity(url, request, Void::class.java)
  }

  fun sendOTP(username: String, code: String): Boolean {
    val url = "$baseUrl/otp/check"

    val body = UserDto(username, code)

    val request = HttpEntity(body)
    val response = rest.postForEntity(url, request, Void::class.java)
    return response.statusCode == HttpStatus.OK
  }
}