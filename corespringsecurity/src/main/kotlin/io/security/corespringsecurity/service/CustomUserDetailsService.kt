package io.security.corespringsecurity.service

import io.security.corespringsecurity.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service("userDetailsService")
class CustomUserDetailsService(
  private val userRepository: UserRepository
): UserDetailsService {

  override fun loadUserByUsername(username: String): UserDetails {
    val account = userRepository.findByUsername(username)
      ?: throw UsernameNotFoundException("username not found exception")

    val roles: MutableList<GrantedAuthority> = mutableListOf()
    roles.add(SimpleGrantedAuthority(account.role))

    return AccountContext(account, roles)
  }

}
