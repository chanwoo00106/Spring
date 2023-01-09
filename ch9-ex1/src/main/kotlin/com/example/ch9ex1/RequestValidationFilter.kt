package com.example.ch9ex1

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class RequestValidationFilter: OncePerRequestFilter() {
  override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
    val requestId = request.getHeader("Request-Id")

    if (requestId == null || requestId.isBlank()) {
      response.status = HttpServletResponse.SC_BAD_REQUEST
      return
    }

    filterChain.doFilter(request, response)
  }
}