package a.a.a.controller

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping("/")
    fun main(@RequestHeader() headers: HttpHeaders): String {
        println(headers["authorization"])
        return "hello world"
    }
}