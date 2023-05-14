package com.example.galladance.data.cloud.source

import com.example.galladance.data.cloud.example.ExampleApi
import com.example.galladance.data.cloud.models.UserCloud
import com.example.galladance.data.cloud.source.handler.ResponseHandler
import com.example.galladance.data.models.UserData
import com.example.galladance.domain.DataRequestState
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.helpers.DispatchersProvider
import kotlinx.coroutines.withContext

class CloudDataSourceImpl(
    private val mapper: Mapper<UserCloud, UserData>,
    private val dispatchersProvider: DispatchersProvider,
) : CloudDataSource {
    private val ex = ExampleApi()
    override suspend fun signIn(login: String, password: String): UserData =
        withContext(dispatchersProvider.io()) {
            mapper.map(ex.signIn(login, password))
        }
}