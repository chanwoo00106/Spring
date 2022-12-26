package com.workshop.security.config

import com.workshop.security.entity.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class InMemoryUserDetailsService: UserDetailsService {
  var users: MutableList<User> = mutableListOf()

  override fun loadUserByUsername(username: String?): UserDetails {
    val user =  users.filter {
        user -> user.username == username
    }

    return SecurityUser(user[0])
  }
}