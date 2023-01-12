package com.example.ch11ex1s1.domain.otp.services

import com.example.ch11ex1s1.domain.otp.Otp
import com.example.ch11ex1s1.domain.otp.respsitory.OtpRepository
import org.springframework.stereotype.Service


@Service
class CheckService (
  private val otpRepository: OtpRepository
) {
  fun execute(otpToValidate: Otp): Boolean {
    val userOtp = otpRepository.findOtpByUsername(otpToValidate.username) ?: return false
    return userOtp.code == otpToValidate.code
  }
}