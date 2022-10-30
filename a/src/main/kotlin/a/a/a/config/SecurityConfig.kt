package a.a.a.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

	@Bean
	fun configure(http: HttpSecurity): SecurityFilterChain {
		return http
			.csrf().disable()
			.formLogin()
			.loginPage("/login")
//			.successForwardUrl("/")
			.failureForwardUrl("/login?error=true")
			.and()
			.authorizeRequests { config ->
				run {
					config.antMatchers("/login").permitAll()
						.antMatchers("/").authenticated()
				}
			}
			.build()
	}

    @Bean
	fun user(): UserDetailsService {
		val user1 = User.builder()
			.username("1234")
			.password(passwordEncoder().encode("1234"))
			.roles("USER")
			.build()

		val admin = User.builder()
			.username("admin")
			.password(passwordEncoder().encode("1234"))
			.roles("ADMIN")
			.build()

		return InMemoryUserDetailsManager(user1, admin)
	}

	@Bean
	fun passwordEncoder(): PasswordEncoder {
		return BCryptPasswordEncoder()
	}
}