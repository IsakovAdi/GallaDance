package com.example.galladance.domain.interactors.cloud

import com.example.galladance.domain.models.User

interface SignInUseCase {
    suspend operator fun invoke(login: String, password: String):User
}