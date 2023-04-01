package com.example.validationtest

import jakarta.validation.constraints.NotEmpty

data class Test (
  @field:NotEmpty(message = "필수값")
  val test: String
)
