package com.shegs.miragefood.di.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.shegs.miragefood.repositories.OnboardingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.datastore by preferencesDataStore(name = "app_preferences")
@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {

    @Provides
    @Singleton
    fun providesOnboardingDatastorePreferences(@ApplicationContext context: Context) =
        context.datastore

    @Provides
    @Singleton
    fun providesOnboardingRepository(
        datastorePreferences: DataStore<Preferences>
    ): OnboardingRepository {
        return OnboardingRepository(onboardingDatastorePreferences = datastorePreferences)
    }


}