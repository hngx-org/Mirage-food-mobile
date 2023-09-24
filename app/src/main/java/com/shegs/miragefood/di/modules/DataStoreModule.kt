package com.shegs.miragefood.di.modules


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.shegs.miragefood.repositories.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.userPreferencesDataStore by preferencesDataStore(name = "user_preferences_datastore")

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {


    @Provides
    @Singleton
    fun providesUserPreferencesDataStore(@ApplicationContext context: Context) =
        context.userPreferencesDataStore


    @Provides
    @Singleton
    fun providesDataStoreRepository(
        datastorePreferences: DataStore<Preferences>
    ): DataStoreRepository {
        return DataStoreRepository(datastorePreferences)
    }

}