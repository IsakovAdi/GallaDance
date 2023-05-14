package com.example.galladance.data.storage.source

import com.example.galladance.data.models.SettingsStateData

interface StorageDataSource {
    suspend fun getSettingsState(): SettingsStateData
    suspend fun saveSettingsState(state: SettingsStateData)
}