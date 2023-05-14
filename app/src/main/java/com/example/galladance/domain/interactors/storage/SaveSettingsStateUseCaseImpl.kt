package com.example.galladance.domain.interactors.storage

import com.example.galladance.domain.models.SettingsState
import com.example.galladance.domain.repositories.StorageRepository
import javax.inject.Inject

class SaveSettingsStateUseCaseImpl @Inject constructor(
    private val repository: StorageRepository,
) : SaveSettingsStateUseCase {
    override suspend fun invoke(state: SettingsState) = repository.saveSettings(state = state)
}