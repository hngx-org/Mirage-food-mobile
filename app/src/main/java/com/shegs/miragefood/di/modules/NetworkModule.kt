package com.shegs.miragefood.di.modules

import com.shegs.miragefood.repositories.NetworkRepository
import com.shegs.miragefood.services.FreeLunchApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun providesClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun providesFreeLunchApiService(client: OkHttpClient): FreeLunchApiService {
        return Retrofit.Builder()
            .baseUrl("https://mirage-backend.onrender.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FreeLunchApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNetworkRepository(apiService: FreeLunchApiService): NetworkRepository {
        return NetworkRepository(apiService)
    }


}