package io.security.basicsecurity

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecurityController {
    @GetMapping
    fun home(): String {
        return "home"
    }
}