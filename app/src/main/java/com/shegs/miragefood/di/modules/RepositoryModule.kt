package com.shegs.miragefood.di.modules

import com.shegs.miragefood.models.repositories.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserDataRepository(): UserDataRepository {
        return UserDataRepository()
    }
}