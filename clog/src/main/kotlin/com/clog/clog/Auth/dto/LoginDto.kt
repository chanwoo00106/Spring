package com.clog.clog.Auth.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class LoginDto (
    @field:Email
    val email: String,

    @field:NotBlank
    val password: String
)