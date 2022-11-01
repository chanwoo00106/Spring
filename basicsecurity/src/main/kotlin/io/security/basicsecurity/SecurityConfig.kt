package io.security.basicsecurity

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component

@Component
class SecurityConfig {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .build()
    }
}