package com.tav.reactive.query

import com.expediagroup.graphql.server.operations.Query
import com.tav.reactive.dto.Conference
import org.springframework.stereotype.Component

@Component
class ConferenceQuery : Query {
    fun conference(): Conference = Conference(name = "GOTO Chicago", location = "virtual")
}