package com.tav.reactive.graphql.config

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
import graphql.schema.GraphQLSchema
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GraphQLConfig {

    /* Overriding the default GraphQLSchema bean with one that includes our custom config
       (Default at: com.expediagroup.graphql.server.spring.NonFederatedSchemaAutoConfiguration */
    @Bean
    fun schema(@Autowired userDetailsRepository: UserDetailsRepository): GraphQLSchema {
        return toSchema(
             // Configuration to inject into the schema generation process
            config = SchemaGeneratorConfig(
                supportedPackages = listOf("com.tav.reactive"),
                hooks = MonadHooks(),
                dataFetcherFactoryProvider = CustomDataFetcherFactoryProvider(ObjectMapper())
            ),
            queries = listOf(TopLevelObject(UserDetailsQuery(userDetailsRepository))),
            subscriptions = listOf(TopLevelObject(UserDetailsSubscription(userDetailsRepository))),
            mutations = listOf(TopLevelObject(UserDetailsMutation(userDetailsRepository)))
        )
    }
}