package revise.revise.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(): Item() {
    var author: String = ""
    var isbn = ""
}