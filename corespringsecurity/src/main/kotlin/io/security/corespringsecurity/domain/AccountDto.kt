package io.security.corespringsecurity.domain

import javax.validation.constraints.*

class AccountDto (
  @field:NotBlank
  var username: String,

  @field:NotBlank
  var password: String,

  @field:Email
  var email: String,

  var age: Int,

  @field:NotBlank
  var role: String
)
