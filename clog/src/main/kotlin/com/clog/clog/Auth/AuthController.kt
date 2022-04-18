package com.clog.clog.Auth

import com.clog.clog.Auth.dto.LoginDto
import com.clog.clog.Auth.dto.RegisterDto
import org.springframework.web.bind.annotation.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    fun register(@RequestBody @Valid value: RegisterDto) = authService.register(value)

    @PostMapping("/login")
    fun login(body: HttpServletResponse, @RequestBody @Valid value: LoginDto) {
        val tokens = authService.login(value)

        val cookie1 = Cookie("accessToken", tokens.accessToken)
        val cookie2 = Cookie("refreshToken", tokens.refreshToken)
        cookie1.isHttpOnly = true
        cookie2.isHttpOnly = true
        body.addCookie(cookie1)
        body.addCookie(cookie2)
    }
}