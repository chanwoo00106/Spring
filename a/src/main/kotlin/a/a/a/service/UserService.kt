package a.a.a.service

import a.a.a.domain.Role
import a.a.a.domain.User

interface UserService {
    fun saveUser(user: User): User
    fun saveRole(role: Role): Role

    fun addRoleToUser(username: String, roleName: String)

    fun findByUsername(username: String): User
    fun findAll(): List<User>
}