package com.clog.clog.login

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
class Controller {
    @GetMapping("/")
    fun hello(): String {
        return "Hello"
    }
}