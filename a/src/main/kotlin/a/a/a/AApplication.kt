package a.a.a

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
class AApplication {}

fun main(args: Array<String>) {
	runApplication<AApplication>(*args)
}
