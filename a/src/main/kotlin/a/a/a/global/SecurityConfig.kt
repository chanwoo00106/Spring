package a.a.a.global

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().disable()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

            .authorizeRequests { auth ->
                run {
                    auth
                        .requestMatchers(RequestMatcher { request -> CorsUtils.isPreFlightRequest(request) })
                        .permitAll()
                        .antMatchers(HttpMethod.GET, "/hi").authenticated()
                        .antMatchers(HttpMethod.GET, "/").permitAll()
                        .anyRequest().permitAll()
                }
            }

            .exceptionHandling { exception ->
                run {
                    exception.authenticationEntryPoint(CustomAuthenticationException(objectMapper))
                }
            }

            .build()
    }
}
