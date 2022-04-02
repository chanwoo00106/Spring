package com.example.srud.repository

import javax.persistence.*

@Entity
class Crud (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String,

    @Column(nullable = false)
    var content: String
)