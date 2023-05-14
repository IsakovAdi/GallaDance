package com.example.galladance.data.repositoryImpl

import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.data.storage.source.StorageDataSource
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.models.SettingsState
import com.example.galladance.domain.repositories.StorageRepository

class StorageRepositoryImpl(
    private val mapToData: Mapper<SettingsState, SettingsStateData>,
    private val mapFromData: Mapper<SettingsStateData, SettingsState>,
    private val dataSource: StorageDataSource,
) : StorageRepository {
    override suspend fun getSettings(): SettingsState =
        mapFromData.map(dataSource.getSettingsState())

    override suspend fun saveSettings(state: SettingsState) =
        dataSource.saveSettingsState(mapToData.map(state))
}