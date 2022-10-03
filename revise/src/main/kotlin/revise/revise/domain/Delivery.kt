package revise.revise.domain

import javax.persistence.*

@Entity
class Delivery (
    @OneToOne(mappedBy = "delivery")
    var order: Order,

    var address: Address,

    @Enumerated(EnumType.STRING)
    var status: DeliveryStatus
) {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    var id: Long = 0

}
