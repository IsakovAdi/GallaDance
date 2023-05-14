package com.example.galladance.data.cloud.source.handler

import com.example.galladance.domain.DataRequestState
import com.example.galladance.domain.Mapper
import retrofit2.Response

interface ResponseHandler {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): DataRequestState<T>
    suspend fun <T, K> safeApiMapperCall(
        mapper: Mapper<T, K>,
        apiCall: suspend () -> Response<T>,
    ): DataRequestState<K>
}