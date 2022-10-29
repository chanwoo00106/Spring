package a.a.a

import org.springframework.security.core.Authentication

class SecurityMessage (
    var message: String,
    var authentication: Authentication
)
