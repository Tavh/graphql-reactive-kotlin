package com.tav.reactive.query


import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.model.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@Component
class UserDetailsQuery : Query {
    fun getUserDetails(id: Int) = Mono.just(UserDetails(id, "Tav"))
}


