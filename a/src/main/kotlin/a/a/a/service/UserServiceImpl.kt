package a.a.a.service

import a.a.a.domain.Role
import a.a.a.domain.User
import a.a.a.dto.RoleToUserDto
import a.a.a.repository.RoleRepository
import a.a.a.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(
    @Autowired
    private val userRepository: UserRepository,
    @Autowired
    private val roleRepository: RoleRepository
): UserService, UserDetailsService  {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException("User not found")

        val authorities: MutableList<SimpleGrantedAuthority> = ArrayList<SimpleGrantedAuthority>()
        user.roles?.forEach { role -> authorities.add(SimpleGrantedAuthority(role.name)) }
        return org.springframework.security.core.userdetails.User(username, user.password, authorities)
    }

    override fun saveUser(user: User): User {
        return userRepository.save(user);
    }

    override fun saveRole(role: Role): Role {
        return roleRepository.save(role)
    }

    override fun addRoleToUser(roleToUser: RoleToUserDto) {
        val user = userRepository.findByUsername(roleToUser.username)
        val role = roleRepository.findByName(roleToUser.roleName)
        user?.roles?.add(role)
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }
}