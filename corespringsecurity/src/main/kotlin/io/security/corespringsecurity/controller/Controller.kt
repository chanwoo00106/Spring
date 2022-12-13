package io.security.corespringsecurity.controller

import io.security.corespringsecurity.domain.Account
import io.security.corespringsecurity.domain.AccountDto
import io.security.corespringsecurity.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController("/")
class Controller(
    val userService: UserService
) {
    @PostMapping("/users")
    fun createUser(@Valid @RequestBody accountDto: AccountDto): Account {
        return userService.createUser(accountDto)
    }
}