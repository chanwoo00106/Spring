package com.example.srud.repository

import javax.persistence.*

@Entity
class Srud() {
    constructor(title: String, content: String) : this() {
        this.title = title
        this.content = content
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    lateinit var title: String

    @Column(nullable = false)
    lateinit var content: String
}