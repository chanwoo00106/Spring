package a.a.a.repository

import a.a.a.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?

    fun existsByUsername(username: String): Boolean
}