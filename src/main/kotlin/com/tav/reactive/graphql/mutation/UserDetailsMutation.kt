package com.tav.reactive.graphql.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.tav.reactive.model.UserDetails
import com.tav.reactive.repository.UserDetailsRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Component

@Component
class UserDetailsMutation(val userDetailsRepository: UserDetailsRepository) : Mutation {
    suspend fun saveUserDetails(userDetails: UserDetails): UserDetails? {
        return userDetailsRepository.save(userDetails).awaitSingleOrNull()
    }
}