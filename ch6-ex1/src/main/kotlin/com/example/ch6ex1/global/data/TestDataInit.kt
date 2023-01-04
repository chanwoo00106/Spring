package com.example.ch6ex1.global.data

import com.example.ch6ex1.domain.authority.Authority
import com.example.ch6ex1.domain.authority.AuthorityRepository
import com.example.ch6ex1.domain.product.Product
import com.example.ch6ex1.domain.product.ProductRepository
import com.example.ch6ex1.domain.user.User
import com.example.ch6ex1.domain.user.UserRepository
import com.example.ch6ex1.domain.user.enums.Algorithm
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class TestDataInit (
  val userRepository: UserRepository,
  val productRepository: ProductRepository,
  val authorityRepository: AuthorityRepository
) {
  @Transactional
  @EventListener(ApplicationReadyEvent::class)
  fun initData() {
    val user = User("chan", "$2a$10\$WO8E7gPGtOkJ2yBtwnFTje4xao/uIcBIWJ5urbcSEyCTDb4glI0dS", Algorithm.BCRYPT)
    val authority1 = Authority("READ", user)
    val authority2 = Authority("WRITE", user)
    val product = Product("Chocolate", 10, "USD")

    userRepository.save(user)
    authorityRepository.save(authority1)
    authorityRepository.save(authority2)
    productRepository.save(product)
  }
}