package com.example.galladance.presentation.di

import com.example.galladance.data.cloud.models.UserCloud
import com.example.galladance.data.cloud.source.cloud.CloudDataSource
import com.example.galladance.data.cloud.source.cloud.CloudDataSourceImpl
import com.example.galladance.data.cloud.source.handler.ResponseHandler
import com.example.galladance.data.cloud.source.handler.ResponseHandlerImpl
import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.data.models.UserData
import com.example.galladance.data.storage.models.SettingsStateStorage
import com.example.galladance.data.storage.source.StorageDataSource
import com.example.galladance.data.storage.source.StorageDataSourceImpl
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.helpers.DispatchersProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SourceModule {
    @Provides
    fun provideResponseHandler(
        dispatchersProvider: DispatchersProvider,
    ): ResponseHandler = ResponseHandlerImpl(dispatchersProvider = dispatchersProvider)

    @Provides
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProvider.Base()

    @Provides
    fun provideCloudDataSourceImpl(
        mapper: Mapper<UserCloud, UserData>,
        dispatchersProvider: DispatchersProvider,
    ): CloudDataSource =
        CloudDataSourceImpl(
            mapper = mapper,
            dispatchersProvider = dispatchersProvider,
        )

    @Provides
    fun provideStorageDataSourceImpl(
        dispatchersProvider: DispatchersProvider,
        mapToStorage: Mapper<SettingsStateData, SettingsStateStorage>,
        mapFromStorage: Mapper<SettingsStateStorage, SettingsStateData>,
    ): StorageDataSource = StorageDataSourceImpl(
        dispatchersProvider = dispatchersProvider,
        mapToStorage = mapToStorage,
        mapFromStorage = mapFromStorage,
    )
}