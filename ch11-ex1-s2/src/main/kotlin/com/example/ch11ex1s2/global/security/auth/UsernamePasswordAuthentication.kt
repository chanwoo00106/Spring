package com.example.ch11ex1s2.global.security.auth

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class UsernamePasswordAuthentication(
  private val principal: Any,
  private val credentials: Any,
  private val authorities: MutableList<GrantedAuthority>?
): UsernamePasswordAuthenticationToken(principal, credentials, authorities) {


}