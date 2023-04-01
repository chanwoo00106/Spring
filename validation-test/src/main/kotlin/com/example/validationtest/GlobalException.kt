package com.example.validationtest

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalException {
  @ExceptionHandler(Exception:: class)
  fun exception(request: HttpServletRequest, e: Exception) {
    println(e.toString())
  }
}