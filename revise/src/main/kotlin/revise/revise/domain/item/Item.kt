package revise.revise.domain.item

import revise.revise.domain.Category
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item (
    var name: String,
    var price: Int,
    var stockQuantity: Int,

    @ManyToMany(mappedBy = "items")
    var categories: List<Category>
        ) {
    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long = 0
}
