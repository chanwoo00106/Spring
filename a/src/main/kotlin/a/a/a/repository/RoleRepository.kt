package a.a.a.repository

import a.a.a.domain.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
    fun findByName(name: String): Role
}