package a.a.a

import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @Secured("ROLE_USER", "ROLE_ADMIN")
    @GetMapping("/user")
    fun user(): SecurityMessage {
        return SecurityMessage("user page", SecurityContextHolder.getContext().authentication)
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    fun admin(): SecurityMessage {
        return SecurityMessage("admin page", SecurityContextHolder.getContext().authentication)
    }
}