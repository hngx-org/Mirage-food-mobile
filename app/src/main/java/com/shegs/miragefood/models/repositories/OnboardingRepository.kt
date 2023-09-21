package com.shegs.miragefood.models.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class OnboardingRepository(
    private val onboardingDatastorePreferences: DataStore<Preferences>,
) {

    suspend fun saveOnBoardingState(isOnBoarded: Boolean) {
        onboardingDatastorePreferences.edit { preferences ->
            preferences[ON_BOARDING_KEY] = isOnBoarded
        }
    }

    fun readOnboardingState(): Flow<Boolean> {
        return onboardingDatastorePreferences.data
            .catch { exception ->
                if (exception is Exception) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                val onBoardingState = preferences[ON_BOARDING_KEY] ?: false
                onBoardingState
            }
    }

    private companion object {
        val ON_BOARDING_KEY = booleanPreferencesKey(
            name = "ON_BOARDING_KEY"
        )
    }
}