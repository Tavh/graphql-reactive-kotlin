package com.tav.reactive.hook

import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import graphql.language.ListType
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.awt.List
import kotlin.reflect.KType
import kotlin.reflect.full.createType

class MonadHooks : SchemaGeneratorHooks {
    override fun willResolveMonad(type: KType): KType = when (type.classifier) {
        Mono::class -> type.arguments.firstOrNull()?.type
        Flux::class -> type.arguments.firstOrNull()?.type
        else -> type
    } ?: type
}