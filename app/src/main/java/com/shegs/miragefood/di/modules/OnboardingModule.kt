package com.shegs.miragefood.di.modules

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.datastore by preferencesDataStore(name = "onboarding_preferences")

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {


    @Provides
    @Singleton
    fun providesOnboardingDatastorePreferences(@ApplicationContext context: Context) =
        context.datastore

//    @Provides
//    @Singleton
//    fun providesOnboardingRepository(
//        datastorePreferences: DataStore<Preferences>
//    ): OnboardingRepository {
//        return OnboardingRepository(onboardingDatastorePreferences = datastorePreferences)
//    }

}