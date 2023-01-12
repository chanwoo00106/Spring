package com.example.ch11ex1s1.domain.otp.respsitory

import com.example.ch11ex1s1.domain.otp.Otp
import org.springframework.data.jpa.repository.JpaRepository

interface OtpRepository: JpaRepository<Otp, String> {
  fun findOtpByUsername(username: String): Otp?
}