package com.tav.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class ReactiveApplication

fun main(args: Array<String>) {
	runApplication<ReactiveApplication>(*args)
}