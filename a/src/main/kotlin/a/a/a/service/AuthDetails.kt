package a.a.a.service

import a.a.a.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String =
        user.password

    override fun getUsername(): String =
        user.username

    override fun isAccountNonExpired(): Boolean =
        true

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }
}