package io.security.corespringsecurity.repository

import io.security.corespringsecurity.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Account, Long> {
}