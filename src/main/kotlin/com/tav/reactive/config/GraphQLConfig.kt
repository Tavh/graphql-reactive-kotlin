package com.tav.reactive.config

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import com.fasterxml.jackson.databind.ObjectMapper
import com.tav.reactive.fetcher.CustomDataFetcherFactoryProvider
import com.tav.reactive.hook.MonadHooks
import com.tav.reactive.query.UserDetailsQuery
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

val configWithReactorMonoMonad = SchemaGeneratorConfig(
    supportedPackages = listOf("com.tav.reactive"),
    hooks = MonadHooks(),
    dataFetcherFactoryProvider = CustomDataFetcherFactoryProvider(ObjectMapper())
)

@Configuration
class GraphQLConfig {
    @Bean
    fun schema() = toSchema(config = configWithReactorMonoMonad, queries = listOf(TopLevelObject(UserDetailsQuery())))
}