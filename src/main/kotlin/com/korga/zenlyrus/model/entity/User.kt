package com.korga.zenlyrus.model.entity

import jakarta.persistence.*

@Entity
@Table(schema = "zenlyrus", name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true)
    var id: Long? = null

    @Column(name = "username", unique = true, nullable = false)
    var username: String? = null

    @Column(name = "password", unique = false, nullable = false)
    var password: String? = null
}