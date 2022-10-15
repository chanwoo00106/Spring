package a.a.a.service

import a.a.a.domain.Role
import a.a.a.domain.User
import a.a.a.repository.RoleRepository
import a.a.a.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
): UserService  {

    override fun saveUser(user: User): User {
        return userRepository.save(user);
    }

    override fun saveRole(role: Role): Role {
        return roleRepository.save(role)
    }

    override fun addRoleToUser(username: String, roleName: String) {
        var user = userRepository.findByUsername(username)
        var role = roleRepository.findByName(roleName)
        user.roles.add(role)
    }

    override fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }
}