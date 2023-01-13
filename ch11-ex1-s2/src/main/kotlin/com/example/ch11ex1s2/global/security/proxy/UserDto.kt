package com.example.ch11ex1s2.global.security.proxy

class UserDto (
  val username: String,
  val password: String,
) {
  var code: String? = null
  constructor(username: String, password: String, code: String): this(username, password) {
    this.code = code
  }
}
