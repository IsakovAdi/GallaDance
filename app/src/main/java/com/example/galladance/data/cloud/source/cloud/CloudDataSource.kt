package com.example.galladance.data.cloud.source.cloud

import com.example.galladance.data.models.UserData

interface CloudDataSource {
    suspend fun signIn(login: String, password: String): UserData
}