package com.example.galladance.presentation.di

import android.content.Context
import com.example.galladance.data.cloud.base.ResourceProvider
import com.example.galladance.data.cloud.source.cloud.CloudDataSource
import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.data.models.UserData
import com.example.galladance.data.repositoryImpl.RepositoryImpl
import com.example.galladance.data.repositoryImpl.StorageRepositoryImpl
import com.example.galladance.data.storage.source.StorageDataSource
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.SettingsState
import com.example.galladance.domain.models.User
import com.example.galladance.domain.repositories.Repository
import com.example.galladance.domain.repositories.StorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideResourceProvider(
        @ApplicationContext context: Context,
    ): ResourceProvider = ResourceProvider.Base(context = context)

    @Provides
    fun provideRepositoryImpl(
        source: CloudDataSource,
        mapper: Mapper<UserData, User>,
    ): Repository = RepositoryImpl(source = source, mapper = mapper)

    @Provides
    fun provideStorageRepositoryImpl(
        mapToData: Mapper<SettingsState, SettingsStateData>,
        mapFromData: Mapper<SettingsStateData, SettingsState>,
        dataSource: StorageDataSource,
    ): StorageRepository = StorageRepositoryImpl(
        mapToData = mapToData,
        mapFromData = mapFromData,
        dataSource = dataSource
    )
}