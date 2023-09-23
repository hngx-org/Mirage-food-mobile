package com.shegs.miragefood.di.modules

import com.shegs.miragefood.models.repositories.SignInRepository
import com.shegs.miragefood.models.repositories.TransactionRepository
import com.shegs.miragefood.models.repositories.UserDataRepository
import com.shegs.miragefood.services.AuthService
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
    @ViewModelScoped
    fun provideSignInRepository(authService : AuthService): SignInRepository {
        return SignInRepository(authService)
    }


}
