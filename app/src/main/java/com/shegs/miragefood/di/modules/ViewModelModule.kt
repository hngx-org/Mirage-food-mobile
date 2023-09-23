package com.shegs.miragefood.di.modules

import com.shegs.miragefood.models.repositories.LunchRepository
import com.shegs.miragefood.repositories.OnboardingRepository
import com.shegs.miragefood.repositories.SignInRepository
import com.shegs.miragefood.repositories.TransactionRepository
import com.shegs.miragefood.services.ApiService
import com.shegs.miragefood.viewmodels.LunchViewModel
import com.shegs.miragefood.viewmodels.SignInViewModel
import com.shegs.miragefood.viewmodels.TransactionViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton


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
    fun provideSignInViewModel(signInRepository: SignInRepository, onboardingRepository: OnboardingRepository): SignInViewModel {
        return SignInViewModel(signInRepository, onboardingRepository)
    }

    @Provides
    @ViewModelScoped // Use the appropriate scope
    fun provideTransactionRepository(): TransactionRepository {
        return TransactionRepository()
    }

    @Provides
    @Singleton
    fun provideSignInRepository(
        apiService: ApiService,
        ): SignInRepository {
        return SignInRepository(apiService)
    }

    @Provides
    @ViewModelScoped
    fun provideLunchRepository(apiService: ApiService): LunchRepository {
        return LunchRepository(apiService)
    }

    @Provides
    @ViewModelScoped
    fun provideLunchViewModel(repository: LunchRepository, onboardingRepository: OnboardingRepository): LunchViewModel {
        return LunchViewModel(repository, onboardingRepository)
    }


}