package a.a.a.service

import a.a.a.domain.Role
import a.a.a.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserServiceImplTest (
    @Autowired
    private val userService: UserServiceImpl
) {
    @Test
    fun saveUser() {
        val user = User("hello", "hi", "dog", null)
        val saveUser = userService.saveUser(user)
        assertThat(user).isEqualTo(saveUser)

        val findUser = userService.findByUsername(user.username)
        assertThat(user).isEqualTo(findUser)
    }

    @Test
     fun saveRole() {
        val role = Role("d")
        val saveRole = userService.saveRole(role)
        assertThat(role).isEqualTo(saveRole)
    }

//    @Test
//    @Transactional(readOnly = false)
//     fun addRoleToUser() {
//     }

    @Test
    fun findByUsername() {
        val user = User("hello", "hi", "dog", null)
        userService.saveUser(user)

        val findUser = userService.findByUsername(user.username)

        assertThat(user).isEqualTo(findUser)
    }

//    @Test
//     fun findAll(): List<User> {
//    }
}