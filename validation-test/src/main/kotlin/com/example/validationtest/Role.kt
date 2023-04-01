package com.example.validationtest

import org.springframework.security.core.GrantedAuthority

enum class Role: GrantedAuthority {
  ROLE_ADMIN, ROLE_A;

  override fun getAuthority(): String = name
}