package revise.revise.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member (
    var name: String,

    @Embedded
    var address: Address,

    @OneToMany(mappedBy = "member")
    var orders: List<Order>
) {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    var id: Long = 0
}