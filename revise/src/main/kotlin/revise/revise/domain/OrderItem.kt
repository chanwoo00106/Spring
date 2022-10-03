package revise.revise.domain

import revise.revise.domain.item.Item
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class OrderItem (
    @ManyToOne
    @JoinColumn(name = "item_id")
    var item: Item,

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order,

    var orderPrice: Int,

    var count: Int
) {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    var id: Long = 0
}