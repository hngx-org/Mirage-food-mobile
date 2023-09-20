package com.shegs.miragefood.di.modules

import com.shegs.miragefood.models.repositories.TransactionRepository
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
}