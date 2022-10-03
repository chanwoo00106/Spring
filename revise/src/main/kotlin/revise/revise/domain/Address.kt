package revise.revise.domain

import javax.persistence.Embeddable

@Embeddable
class Address (
    var city: String,
    var streat: String,
    var zipcode: String
)
