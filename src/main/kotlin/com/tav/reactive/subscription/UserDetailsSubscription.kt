package com.tav.reactive.subscription


import com.expediagroup.graphql.server.operations.Query
import com.expediagroup.graphql.server.operations.Subscription
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux

@Component
class UserDetailsSubscription(val userDetailsRepository: UserDetailsRepository) : Subscription {
    suspend fun getAllUserDetails(): Flux<UserDetails?> {
        return userDetailsRepository.findAll()
    }
}


