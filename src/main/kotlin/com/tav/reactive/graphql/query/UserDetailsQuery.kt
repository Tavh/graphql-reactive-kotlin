package com.tav.reactive.graphql.query

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.stream.Collectors

@Component
class UserDetailsQuery(val userDetailsRepository: UserDetailsRepository) : Query {
    @GraphQLDescription("Retrieves a single user by it's id")
    fun getUserDetails(id: Int): Mono<UserDetails> = userDetailsRepository.findById(id)
    @GraphQLDescription("Streams all the users from the db into a list, then returns the list")
    fun getAllUserDetails(): Mono<MutableList<UserDetails>> = userDetailsRepository.findAll().collect(Collectors.toList())
}


