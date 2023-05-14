package com.example.galladance.domain.repositories

import com.example.galladance.domain.models.User

interface Repository {
    suspend fun signIn(login: String, password: String): User
}