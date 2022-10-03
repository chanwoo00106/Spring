package revise.revise.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long = 0

    var name: String = ""
    var price: Int = 0
    var stockQuantity: Int = 0
}
