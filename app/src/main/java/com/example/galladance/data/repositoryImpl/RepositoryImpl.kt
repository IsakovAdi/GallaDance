package com.example.galladance.data.repositoryImpl

import com.example.galladance.data.cloud.source.cloud.CloudDataSource
import com.example.galladance.data.models.UserData
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.User
import com.example.galladance.domain.repositories.Repository

class RepositoryImpl(
    private val source: CloudDataSource,
    private val mapper: Mapper<UserData, User>,
) : Repository {
    override suspend fun signIn(login: String, password: String): User =
        mapper.map(source.signIn(login = login, password = password))
}