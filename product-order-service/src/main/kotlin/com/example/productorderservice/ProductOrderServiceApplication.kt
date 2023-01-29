package com.example.productorderservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductOrderServiceApplication

fun main(args: Array<String>) {
  runApplication<ProductOrderServiceApplication>(*args)
}
