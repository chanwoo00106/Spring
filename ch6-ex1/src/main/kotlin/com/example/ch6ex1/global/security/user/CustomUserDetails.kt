package com.example.ch6ex1.global.security.user

import com.example.ch6ex1.domain.user.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails (
  val user: User
): UserDetails {
  override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
    val roles = mutableListOf<GrantedAuthority>()
    user.authorities.stream().map { i -> roles.add(SimpleGrantedAuthority(i.name)) }

    return roles
  }

  override fun getPassword(): String {
    return user.password
  }

  override fun getUsername(): String {
    return user.username
  }

  override fun isAccountNonExpired(): Boolean {
    return true
  }

  override fun isAccountNonLocked(): Boolean {
    return true
  }

  override fun isCredentialsNonExpired(): Boolean {
    return true
  }

  override fun isEnabled(): Boolean {
    return true
  }
}