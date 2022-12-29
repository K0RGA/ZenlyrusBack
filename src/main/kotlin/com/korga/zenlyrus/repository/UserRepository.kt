package com.korga.zenlyrus.repository

import com.korga.zenlyrus.model.entity.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    @EntityGraph(attributePaths = ["friendList"], type = EntityGraph.EntityGraphType.FETCH)
    fun findByUsername(username: String): Optional<User>
}