package com.shegs.miragefood.di.modules

import com.shegs.miragefood.services.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val baseUrl = "https://mirage-backend.onrender.com/api/"
        val retrofit: Retrofit by lazy {
            Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).build()
        }
        return retrofit
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

}