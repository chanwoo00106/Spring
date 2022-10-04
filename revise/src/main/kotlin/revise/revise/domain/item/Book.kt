package revise.revise.domain.item

import revise.revise.domain.Category
import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@DiscriminatorValue("B")
class Book(
    name: String,
    price: Int,
    stockQuantity: Int,
    categories: MutableList<Category>,
    var author: String,
    var isbn: String
): Item(name, price, stockQuantity, categories)