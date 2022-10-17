package a.a.a.service

import a.a.a.domain.Role
import a.a.a.domain.User
import a.a.a.dto.RoleToUserDto

interface UserService {
    fun saveUser(user: User): User
    fun saveRole(role: Role): Role

    fun addRoleToUser(roleToUser: RoleToUserDto)

    fun findByUsername(username: String): User?
    fun findAll(): List<User>
}