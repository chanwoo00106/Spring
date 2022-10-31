package a.a.a.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Authority(
    var authority: String
){
    @Id @GeneratedValue
    @ManyToOne
    val id: Long = 0
}