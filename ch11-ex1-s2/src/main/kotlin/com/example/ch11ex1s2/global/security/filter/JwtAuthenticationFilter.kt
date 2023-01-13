package com.example.ch11ex1s2.global.security.filter

import com.example.ch11ex1s2.global.security.auth.UsernamePasswordAuthentication
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationFilter: OncePerRequestFilter() {
  @Value("\${jwt.signing.key}")
  private val signingKey: String = ""
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val jwt = request.getHeader("Authorization")

    val key = Keys.hmacShaKeyFor(signingKey.toByteArray(StandardCharsets.UTF_8))
    val claims = Jwts.parserBuilder()
      .setSigningKey(key)
      .build()
      .parseClaimsJws(jwt)
      .body
    val username = claims["username"].toString()

    val authority = SimpleGrantedAuthority(username)
    val auth = UsernamePasswordAuthentication(
      username,
      "",
      mutableListOf(authority)
    )
    SecurityContextHolder.getContext().authentication = auth
    filterChain.doFilter(request, response)
  }

  override fun shouldNotFilter(request: HttpServletRequest): Boolean {
    return request.servletPath == "/login"
  }
}