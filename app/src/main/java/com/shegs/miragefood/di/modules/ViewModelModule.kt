package com.shegs.miragefood.di.modules

import com.shegs.miragefood.repositories.TransactionRepository
import com.shegs.miragefood.viewmodels.TransactionViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Provides
    @Singleton
    fun provideTransactionViewModel(transactionRepository: TransactionRepository): TransactionViewModel {
        return TransactionViewModel(transactionRepository)
    }


    @Provides
    @Singleton
    fun provideTransactionRepository(): TransactionRepository {
        return TransactionRepository()
    }

}