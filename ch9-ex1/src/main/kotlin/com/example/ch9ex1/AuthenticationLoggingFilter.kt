package com.example.ch9ex1

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationLoggingFilter: OncePerRequestFilter() {
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val requestId = request.getHeader("Request-Id")
    logger.info("Successfully authenticated request with id $requestId")

    filterChain.doFilter(request, response)
  }
}