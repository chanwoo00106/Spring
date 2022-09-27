package revise.revise

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member(
    var username: String
) {
    @Id
    @GeneratedValue
    var id: Long = 0
}