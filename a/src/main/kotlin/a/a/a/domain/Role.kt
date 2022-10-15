package a.a.a.domain

import javax.persistence.*

@Entity
class Role (
    val name: String
) {
    @Id @GeneratedValue
    val id: Long = 0
}