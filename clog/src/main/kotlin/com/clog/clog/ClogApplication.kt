package com.clog.clog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClogApplication

fun main(args: Array<String>) {
    runApplication<ClogApplication>(*args)
}
