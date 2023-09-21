package com.shegs.miragefood.di.modules

import com.shegs.miragefood.models.repositories.SearchRepository
import com.shegs.miragefood.models.repositories.TransactionRepository
import com.shegs.miragefood.models.repositories.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserDataRepository(): UserDataRepository {
        return UserDataRepository()
    }

    @Provides
    @ViewModelScoped // Use the appropriate scope
    fun provideTransactionRepository(): TransactionRepository {
        return TransactionRepository()
    }

    @Provides
    @Singleton
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository()
    }


}
