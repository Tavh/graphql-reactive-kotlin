package com.tav.reactive.graphql.fetcher

import com.expediagroup.graphql.generator.execution.FunctionDataFetcher
import com.expediagroup.graphql.generator.execution.SimpleKotlinDataFetcherFactoryProvider
import com.fasterxml.jackson.databind.ObjectMapper
import graphql.schema.DataFetcherFactory
import graphql.schema.DataFetchingEnvironment
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.reflect.KFunction

class CustomFunctionDataFetcher(target: Any?, fn: KFunction<*>, objectMapper: ObjectMapper) : FunctionDataFetcher(target, fn, objectMapper) {
  override fun get(environment: DataFetchingEnvironment): Any? = when (val result = super.get(environment)) {
    is Mono<*> -> result.toFuture()
    is Flux<*> -> result.collectList().toFuture()
    else -> result
  }
}

class CustomDataFetcherFactoryProvider(private val objectMapper: ObjectMapper) : SimpleKotlinDataFetcherFactoryProvider(objectMapper) {
  override fun functionDataFetcherFactory(target: Any?, kFunction: KFunction<*>): DataFetcherFactory<Any?> {
    return DataFetcherFactory<Any?> { CustomFunctionDataFetcher(target = target, fn = kFunction, objectMapper = objectMapper) }
  }

}