package com.korga.zenlyrus.model

import jakarta.persistence.*

@Entity
@Table(schema = "zenlyrus", name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true, nullable = true)
    val id: Long? = null

    @Column (name = "username", unique = true, nullable = false)
    var username: String? = null

    @Column (name = "password", unique = false, nullable = false)
    var password: String? = null
}