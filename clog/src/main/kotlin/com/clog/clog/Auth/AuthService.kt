package com.clog.clog.Auth

import com.clog.clog.Auth.dto.RegisterDto
import com.clog.clog.Models.Entities.User
import com.clog.clog.Models.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class AuthService(
    private val userRepository: UserRepository,
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun register(value: RegisterDto) {
        if (userRepository.findByEmail(value.email) != null) throw ResponseStatusException(HttpStatus.FORBIDDEN);
        val hash = passwordEncoder.encode(value.password)
        val user = User(email = value.email, name = value.name, password = hash)
        println(user.name)
        userRepository.save(user)
    }
}