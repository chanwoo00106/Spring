package io.security.corespringsecurity.domain

import javax.persistence.*

@Entity
class Account(
        var username: String,
        var password: String,
        var email: String,
        var age: Int,
        var role: String
) {
    @Id @GeneratedValue
    val id: Long = 0
}