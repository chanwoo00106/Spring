package com.workshop.security.config

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class DummyUser: UserDetails {
  override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
    return mutableListOf(GrantedAuthority {"READ"})
  }

  override fun getPassword(): String {
    return "1234"
  }

  override fun getUsername(): String {
    return "chan"
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