package com.tav.reactive.graphql.query


import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.stream.Collectors

@Component
class UserDetailsQuery(val userDetailsRepository: UserDetailsRepository) : Query {
    fun getUserDetails(id: Int) = userDetailsRepository.findById(id)
    fun getAllUserDetails(): Mono<MutableList<UserDetails>> = userDetailsRepository.findAll().collect(Collectors.toList())
}


