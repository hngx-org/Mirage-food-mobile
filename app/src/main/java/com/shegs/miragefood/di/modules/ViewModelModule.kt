package com.shegs.miragefood.di.modules

import com.shegs.miragefood.repositories.SignInRepository
import com.shegs.miragefood.repositories.TransactionRepository
import com.shegs.miragefood.services.ApiService
import com.shegs.miragefood.viewmodels.SignInViewModel
import com.shegs.miragefood.viewmodels.TransactionViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideTransactionViewModel(transactionRepository: TransactionRepository): TransactionViewModel {
        return TransactionViewModel(transactionRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideSignInViewModel(signInRepository: SignInRepository): SignInViewModel {
        return SignInViewModel(signInRepository)
    }

    @Provides
    @ViewModelScoped // Use the appropriate scope
    fun provideTransactionRepository(): TransactionRepository {
        return TransactionRepository()
    }

    @Provides
    @ViewModelScoped
    fun provideSignInRepository(apiService : ApiService): SignInRepository {
        return SignInRepository(apiService)
    }

}