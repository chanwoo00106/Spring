package com.example.ch11ex1s1.domain.user.services

import com.example.ch11ex1s1.domain.otp.Otp
import com.example.ch11ex1s1.domain.otp.respsitory.OtpRepository
import com.example.ch11ex1s1.domain.user.User
import com.example.ch11ex1s1.domain.user.repository.UserRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.Random
import javax.transaction.Transactional

@Service
@Transactional
class AuthService (
  private val userRepository: UserRepository,
  private val passwordEncoder: PasswordEncoder,
  private val otpRepository: OtpRepository
) {
  fun execute(user: User) {
    val findUser = userRepository.findUserByUsername(user.username)
      ?: throw BadCredentialsException("Bad credentials")
    if (!passwordEncoder.matches(user.password, findUser.password)) throw BadCredentialsException("Bad credentials")

    val code = createOtp()
    otpRepository.save(Otp(user.username, code))
  }

  private fun createOtp(): String {
    val random = Random()
    return (random.nextInt(90000) + 10000).toString() // 5자리 난수
  }
}