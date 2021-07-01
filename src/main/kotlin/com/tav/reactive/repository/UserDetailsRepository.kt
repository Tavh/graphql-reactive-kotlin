package com.tav.reactive.repository

import com.tav.reactive.model.UserDetails
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserDetailsRepository : ReactiveCrudRepository<UserDetails?, Int?>