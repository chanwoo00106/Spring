package a.a.a.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User (
    @Column(length = 50, unique = true)
    val username: String,

    @JsonIgnore
    @Column(length = 100)
    val password: String,

    @Column(length = 50)
    val nickname: String,

    @JsonIgnore
    val activated: Boolean
) {
    @Id @GeneratedValue
    val id: Long = 0
}