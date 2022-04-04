package com.clog.clog.Models.Entities

import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column
    val name: String,

    @Column(unique = true)
    val email: String,

    @Column()
    val password: String,
)