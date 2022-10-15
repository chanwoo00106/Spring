package a.a.a.domain

import javax.persistence.*

@Entity
class User (
    var name: String,

    @Column(unique = true)
    var username: String,

    var password: String,

    @ManyToMany
    @Column(nullable = true)
    var roles: MutableList<Role>?
) {
    @Id @GeneratedValue
    val id: Long = 0
}