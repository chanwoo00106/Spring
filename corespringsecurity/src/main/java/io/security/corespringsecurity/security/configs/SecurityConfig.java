package io.security.corespringsecurity.security.configs;

import jakarta.websocket.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        String password = passwordEncoder().encode("1234");
        UserDetails user = User.withUsername("user")
            .password(password)
            .roles("USER")
            .build();
        UserDetails user1 = User.withUsername("admin")
            .password(password)
            .roles("ADMIN")
            .build();
        UserDetails user2 = User.withUsername("manager")
            .password(password)
            .roles("MANAGER")
            .build();
        return new InMemoryUserDetailsManager(user, user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((auth) -> auth
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/mypage").hasRole("USER")
                    .requestMatchers("/messages").hasRole("MANAGER")
                    .requestMatchers("/config").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
                .formLogin();
        return http.build();
    }
}
