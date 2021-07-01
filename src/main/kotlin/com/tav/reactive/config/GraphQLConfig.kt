package com.tav.reactive.config

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import com.fasterxml.jackson.databind.ObjectMapper
import com.tav.reactive.graphql.fetcher.CustomDataFetcherFactoryProvider
import com.tav.reactive.graphql.hook.MonadHooks
import com.tav.reactive.graphql.mutation.UserDetailsMutation
import com.tav.reactive.graphql.query.UserDetailsQuery
import com.tav.reactive.repository.UserDetailsRepository
import com.tav.reactive.graphql.subscription.UserDetailsSubscription
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

val configWithReactorMonad = SchemaGeneratorConfig(
    supportedPackages = listOf("com.tav.reactive"),
    hooks = MonadHooks(),
    dataFetcherFactoryProvider = CustomDataFetcherFactoryProvider(ObjectMapper())
)

@Configuration
class GraphQLConfig {
    @Bean
    fun schema(@Autowired userDetailsRepository: UserDetailsRepository) = toSchema(
        config = configWithReactorMonad,
        queries = listOf(TopLevelObject(UserDetailsQuery(userDetailsRepository))),
        subscriptions = listOf(TopLevelObject(UserDetailsSubscription(userDetailsRepository))),
        mutations = listOf(TopLevelObject(UserDetailsMutation(userDetailsRepository)))
    )
}