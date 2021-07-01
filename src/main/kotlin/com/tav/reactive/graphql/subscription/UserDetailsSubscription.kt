package com.tav.reactive.graphql.subscription


import com.expediagroup.graphql.server.operations.Subscription
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class UserDetailsSubscription(val userDetailsRepository: UserDetailsRepository) : Subscription {
    suspend fun streamAllUserDetails(): Flux<UserDetails> {
        return userDetailsRepository.findAll()
    }
}


