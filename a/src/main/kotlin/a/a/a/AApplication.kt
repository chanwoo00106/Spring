package a.a.a

import a.a.a.domain.Role
import a.a.a.domain.User
import a.a.a.dto.RoleToUserDto
import a.a.a.service.UserServiceImpl
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class AApplication {
	@Bean
	fun run(userService: UserServiceImpl): CommandLineRunner {
		return CommandLineRunner { args ->
			userService.saveRole(Role("ROLE_USER"))
			userService.saveRole(Role("ROLE_MEMBER"))
			userService.saveRole(Role("ROLE_ADMIN"))
			userService.saveRole(Role("ROLE_SUPER_ADMIN"))

			userService.saveUser(User("chan", "hello", "world", null))
			userService.saveUser(User("Teemo", "hell2", "world2", null))
			userService.saveUser(User("hahaha", "hello3", "world3", null))
			userService.saveUser(User("they1234", "hello4", "world4", null))

			userService.addRoleToUser(RoleToUserDto("hello", "ROLE_USER"))
		}
	}

	@Bean
	fun passwordEncoder(): BCryptPasswordEncoder {
		return BCryptPasswordEncoder()
	}
}

fun main(args: Array<String>) {
	runApplication<AApplication>(*args)
}
