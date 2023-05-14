package com.example.galladance.presentation.di

import com.example.galladance.domain.interactors.SignInUseCase
import com.example.galladance.domain.interactors.SignInUseCaseImpl
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
}