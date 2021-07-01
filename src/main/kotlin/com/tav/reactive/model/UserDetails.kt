package com.tav.reactive.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user_details")
data class UserDetails(
    @Id
    val id: Int?,

    val name: String
    ) {
    constructor() : this(null, "")
}