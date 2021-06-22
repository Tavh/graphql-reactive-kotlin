package com.tav.reactive.query

import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.dto.Conference
import org.springframework.stereotype.Component

@Component
class UserDetailsQuery : Query {
    fun userDetails(): UserDetails = UserDetails(name = "Tav", age = 25)
}