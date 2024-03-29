package io.security.basicsecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component

@Component
class SecurityConfig (
    @Autowired
    val userDetailsService: UserDetailsService
) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()

            .formLogin()
//            .loginPage("/loginPage")
            .defaultSuccessUrl("/")
            .failureUrl("/login")
            .usernameParameter("userId")
            .passwordParameter("passwd")
            .loginProcessingUrl("/login_proc")
            .successHandler { request, response, authentication ->
                println("authentication ${authentication.name}")
                response.sendRedirect("/")
            }
            .failureHandler { request, response, exception ->
                println("exception ${exception.message}")
                response.sendRedirect("/login")
            }
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .addLogoutHandler {
                request, response, authentication ->
                val session = request.getSession()
                session.invalidate()
            }
            .logoutSuccessHandler {
                request, response, authentication ->
                response.sendRedirect("/login")
            }
            .deleteCookies("remember-me", "JSESSIONID")
            .and()
            .rememberMe()
            .rememberMeParameter("remember")
            .tokenValiditySeconds(3600)
            .userDetailsService(userDetailsService)
            .and()
            .build()
    }
}