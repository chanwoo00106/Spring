package com.example.ch10ex1

import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CsrfTokenLogger: OncePerRequestFilter() {
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val token = request.getAttribute("_csrf") as CsrfToken

    logger.info("CSRF token ${token.token}")
    filterChain.doFilter(request, response)
  }
}