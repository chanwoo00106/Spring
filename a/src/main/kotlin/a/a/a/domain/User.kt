package a.a.a.domain

import javax.persistence.*

@Entity
class User (
    var name: String,

    var username: String,

    var password: String,

    @ManyToMany
    var roles: MutableList<Role>
) {
    @Id @GeneratedValue
    val id: Long = 0
}