package com.example.ch11ex1s2.global.security.filter

import com.example.ch11ex1s2.global.security.auth.OtpAuthentication
import com.example.ch11ex1s2.global.security.auth.UsernamePasswordAuthentication
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class InitialAuthenticationFilter(
  private val manager: AuthenticationManager
): OncePerRequestFilter() {
  @Value("\${jwt.signing.key}")
  private val signingKey: String = ""

  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val username = request.getHeader("username")
    val password = request.getHeader("password")
    val code = request.getHeader("code")

    if (code == null) {
      val auth = UsernamePasswordAuthentication(username, password)
      manager.authenticate(auth)
    } else {
      val auth = manager.authenticate(OtpAuthentication(username, password))
      val key = Keys.hmacShaKeyFor(
        signingKey.toByteArray(StandardCharsets.UTF_8)
      )

      val jwt = Jwts.builder()
        .claim("username", username)
        .signWith(key)
        .compact()
      response.setHeader("Authorization", jwt)
    }
  }

  override fun shouldNotFilter(request: HttpServletRequest): Boolean {
    return request.servletPath != "/login"
  }

}