package io.security.corespringsecurity.service

import io.security.corespringsecurity.domain.Account
import io.security.corespringsecurity.domain.AccountDto

interface UserService {
    fun createUser(accountDto: AccountDto): Account
}