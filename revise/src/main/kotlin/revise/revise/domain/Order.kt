package revise.revise.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order (
    @ManyToOne
    @JoinColumn(name = "member_id")
    var member: Member,

    @OneToMany(mappedBy = "order")
    var orderItems: List<OrderItem>,

    @OneToOne
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery,

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus
) {
    @Id @GeneratedValue
    @Column(name = "order_id")
    var id: Long = 0
}
