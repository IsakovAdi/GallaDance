package com.example.galladance.domain.interactors.storage

import com.example.galladance.domain.models.SettingsState

interface GetSettingsStateUseCase {
    suspend operator fun invoke(): SettingsState
}