package com.clog.clog.Auth

import com.clog.clog.Auth.dto.LoginDto
import com.clog.clog.Auth.dto.RegisterDto
import com.clog.clog.Auth.dto.TokenResDto
import com.clog.clog.Models.Entities.User
import com.clog.clog.Models.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import io.jsonwebtoken.*
import java.util.Date


@Service
class AuthService(
    private val userRepository: UserRepository,
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun register(value: RegisterDto) {
        if (userRepository.findByEmail(value.email) != null) throw ResponseStatusException(HttpStatus.FORBIDDEN)
        val hash = passwordEncoder.encode(value.password)
        val user = User(email = value.email, name = value.name, password = hash)
        userRepository.save(user)
    }

    fun login(value: LoginDto): TokenResDto {
        val user = userRepository.findByEmail(value.email) ?: throw ResponseStatusException(HttpStatus.FORBIDDEN)

        if (!passwordEncoder.matches(value.password, user.password)) throw ResponseStatusException(HttpStatus.FORBIDDEN)

        println(Date(System.currentTimeMillis() + 60 * 10 * 1000))

        val accessToken = Jwts.builder()
            .setIssuer(user.email)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 10 * 1000))
            .signWith(SignatureAlgorithm.HS256, "secret")
            .compact()
        val refreshToken = Jwts.builder()
            .setIssuer(user.email)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS256, "rt-secret")
            .compact()

        return TokenResDto(accessToken, refreshToken)
    }
}