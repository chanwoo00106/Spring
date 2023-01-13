package com.example.ch11ex1s2.global.security.auth

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class OtpAuthentication: UsernamePasswordAuthenticationToken {
  var principal: Any? = null
  var credentials: Any? = null
  var authorities: MutableList<GrantedAuthority>? = null
  constructor(
    principal: Any,
    credentials: Any
  ): super(principal, credentials) {
    this.principal = principal
    this.credentials = credentials
  }
  constructor(
    principal: Any,
    credentials: Any,
    authorities: MutableList<GrantedAuthority>
  ): super(principal, credentials, authorities) {
    this.principal = principal
    this.credentials = credentials
    this.authorities = authorities
  }
}