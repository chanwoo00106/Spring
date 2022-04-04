package com.clog.clog.Auth

import com.clog.clog.Auth.dto.RegisterDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping()
    fun register(@RequestBody @Valid value: RegisterDto) = authService.register(value)
}