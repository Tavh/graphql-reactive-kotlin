package com.tav.reactive.graphql.subscription


import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Subscription
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.time.Duration

@Component
class UserDetailsSubscription(val userDetailsRepository: UserDetailsRepository) : Subscription {
    @GraphQLDescription("Streams all the users in the db")
    fun streamAllUserDetails(): Flux<UserDetails> {
        println("CURRENT THREAD: ${Thread.currentThread()}")
        return userDetailsRepository.findAll()
            .subscribeOn(Schedulers.newSingle("streamer"))
            .delayElements(Duration.ofMillis(1000))
    }
}


