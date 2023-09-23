package com.shegs.miragefood.di.modules

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.shegs.miragefood.repositories.UserDataRepository
import com.shegs.miragefood.services.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Provides
    @Singleton
    fun provideUserDataRepository(): UserDataRepository {
        return UserDataRepository()
    }

    @Provides
    fun provideAuthService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}
