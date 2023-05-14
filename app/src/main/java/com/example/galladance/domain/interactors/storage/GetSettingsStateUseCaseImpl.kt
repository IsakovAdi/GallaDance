package com.example.galladance.domain.interactors.storage

import com.example.galladance.domain.repositories.StorageRepository
import javax.inject.Inject

class GetSettingsStateUseCaseImpl @Inject constructor(
    private val repository: StorageRepository,
) : GetSettingsStateUseCase {
    override suspend fun invoke() = repository.getSettings()
}