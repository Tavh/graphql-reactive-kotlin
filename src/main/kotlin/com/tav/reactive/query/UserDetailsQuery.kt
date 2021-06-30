package com.tav.reactive.query


import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.model.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserDetailsQuery : Query {
    fun getUserDetails(id: Int): Mono<UserDetails> = Mono.just(UserDetails(id, "Tav"))
}


