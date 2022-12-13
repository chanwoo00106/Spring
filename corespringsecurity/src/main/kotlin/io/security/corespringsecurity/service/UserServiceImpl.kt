package io.security.corespringsecurity.service

import io.security.corespringsecurity.domain.Account
import io.security.corespringsecurity.domain.AccountDto
import io.security.corespringsecurity.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
  private val passwordEncoder: PasswordEncoder,
  private val userRepository: UserRepository
): UserService {

  override fun createUser(accountDto: AccountDto): Account {
    val account = Account(
      accountDto.username,
      passwordEncoder.encode(accountDto.password),
      accountDto.email,
      accountDto.age,
      accountDto.role
    )

    return userRepository.save(account)
  }
}