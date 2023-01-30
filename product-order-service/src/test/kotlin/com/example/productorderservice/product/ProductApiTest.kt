package com.example.productorderservice.product

import com.example.productorderservice.ApiTest
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest
class ProductApiTest: ApiTest() {

  @Test
  fun 상품등록() {
    val request = 상품등록요청_생성()
    val response = 상품등록_요청(request)
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
  }

  fun 상품등록_요청(request: AddProductRequest): ExtractableResponse<Response> {
    return RestAssured.given().log().all()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(request)
      .`when`()
      .post("/products")
      .then()
      .log().all().extract()
  }

  fun 상품등록요청_생성(): AddProductRequest {
    val name = "상품명"
    val price = 1000
    val discountPolicy = DiscountPolicy.NONE
    return AddProductRequest(name, price, discountPolicy)
  }
}


