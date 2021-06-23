package com.tav.reactive.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserDetailsMutation(private val userDetailsRepository: UserDetailsRepository) : Mutation {
    fun saveUserDetails(userDetails: UserDetails): Mono<UserDetails> {
        return userDetailsRepository.save(userDetails)
    }
}