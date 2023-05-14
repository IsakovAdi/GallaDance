package com.example.galladance.domain.interactors.storage

import com.example.galladance.domain.models.SettingsState

interface SaveSettingsStateUseCase {
    suspend operator fun invoke(state: SettingsState)
}