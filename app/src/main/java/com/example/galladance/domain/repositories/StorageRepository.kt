package com.example.galladance.domain.repositories

import com.example.galladance.domain.models.SettingsState

interface StorageRepository {
    suspend fun getSettings(): SettingsState
    suspend fun saveSettings(state: SettingsState)
}