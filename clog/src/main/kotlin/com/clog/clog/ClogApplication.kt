package com.clog.clog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class ClogApplication

fun main(args: Array<String>) {
    runApplication<ClogApplication>(*args)
}
