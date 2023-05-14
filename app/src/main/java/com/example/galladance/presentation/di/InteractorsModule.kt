package com.example.galladance.presentation.di

import com.example.galladance.domain.interactors.cloud.SignInUseCase
import com.example.galladance.domain.interactors.cloud.SignInUseCaseImpl
import com.example.galladance.domain.interactors.storage.GetSettingsStateUseCase
import com.example.galladance.domain.interactors.storage.GetSettingsStateUseCaseImpl
import com.example.galladance.domain.interactors.storage.SaveSettingsStateUseCase
import com.example.galladance.domain.interactors.storage.SaveSettingsStateUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InteractorsModule {

    @Binds
    abstract fun bindSignInUseCase(
        implementation: SignInUseCaseImpl,
    ): SignInUseCase

    @Binds
    abstract fun bindGetSettingsStateUseCase(
        implementation: GetSettingsStateUseCaseImpl,
    ): GetSettingsStateUseCase

    @Binds
    abstract fun bindSaveSettingsStateUseCase(
        implementation: SaveSettingsStateUseCaseImpl,
    ): SaveSettingsStateUseCase
}