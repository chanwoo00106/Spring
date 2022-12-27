package com.example.ch3ex2

import com.example.ch3ex2.domain.Authorities
import com.example.ch3ex2.domain.User
import com.example.ch3ex2.repository.AuthoritiesRepository
import com.example.ch3ex2.repository.UserRepository
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class InitData (
  val authoritiesRepository: AuthoritiesRepository,
  val userRepository: UserRepository
) {
  @EventListener(ApplicationReadyEvent::class)
  fun initData() {
    val user = User("chan", "1234", true)
    val authorities = Authorities("chan", "write")

    authoritiesRepository.save(authorities)
    userRepository.save(user)
  }
}