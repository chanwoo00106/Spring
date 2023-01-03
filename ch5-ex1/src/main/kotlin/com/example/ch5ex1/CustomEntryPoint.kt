package com.example.ch5ex1

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

// 인증이 실패했을 경우에만 싱행이 됨
class CustomEntryPoint: AuthenticationEntryPoint {

  override fun commence(
    request: HttpServletRequest,
    response: HttpServletResponse,
    authException: AuthenticationException?
  ) {
    response.addHeader("message", "hi")
    response.sendError(HttpStatus.UNAUTHORIZED.value())
  }
}