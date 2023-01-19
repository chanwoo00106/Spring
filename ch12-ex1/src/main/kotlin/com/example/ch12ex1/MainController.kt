package com.example.ch12ex1

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.logging.Logger

@Controller
class MainController {
  private val logger = Logger.getLogger(MainController::class.java.name)
  @GetMapping
  fun main(token: OAuth2AuthenticationToken): String {
    logger.info(token.principal.toString())
    return "main.html"
  }
}