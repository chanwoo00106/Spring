package revise.revise.domain.item

import revise.revise.domain.Category
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
    name: String,
    price: Int,
    stockQuantity: Int,
    categories: List<Category>,
    var author: String,
    var isbn: String
): Item(name, price, stockQuantity, categories)