package a.a.a.domain

import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
abstract class User(
    @Id
    var userId: String,

    @Column(unique = true)
    var email: String,

    var name: String,

    var enabled: Boolean,

    var created: LocalDateTime,

    var updated: LocalDateTime,

    @OneToMany
    var authorities: Set<Authority>
)