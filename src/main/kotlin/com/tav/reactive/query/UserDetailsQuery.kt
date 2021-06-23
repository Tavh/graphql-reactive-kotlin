package com.tav.reactive.query

import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserDetailsQuery(private val userDetailsRepository: UserDetailsRepository) : Query {
    fun fetchUserDetails(id: Int): Mono<UserDetails> {
        val userDetails = userDetailsRepository.findById(id)
        println(userDetails)
        return userDetails
    }
}