package com.example.productorderservice

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest
class ApiTest {
  @LocalServerPort
  private val port: Int = 8080

  @BeforeEach
  fun setUp() {
    RestAssured.port = port
  }
}