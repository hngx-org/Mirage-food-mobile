package com.shegs.miragefood.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class DataStoreRepository(
    private val userPreferencesDataStore: DataStore<Preferences>,
) {
    suspend fun saveOnBoardingState(isOnBoarded: Boolean) {
        userPreferencesDataStore.edit { preferences ->
            preferences[ON_BOARDING_KEY] = isOnBoarded
        }
    }

    fun readOnboardingState(): Flow<Boolean> {
        return userPreferencesDataStore.data
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

    suspend fun saveAccessToken(accessToken: String) {
        userPreferencesDataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = accessToken
        }
        Log.i("access token saved",accessToken)
    }

    fun readAccessToken(): Flow<String> {
        return userPreferencesDataStore.data
            .catch { exception ->
                if (exception is Exception) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                val accessToken = preferences[ACCESS_TOKEN_KEY] ?: ""
                accessToken
            }
    }

    private companion object {
        val ON_BOARDING_KEY = booleanPreferencesKey(
            name = "ON_BOARDING_KEY"
        )
        val ACCESS_TOKEN_KEY = stringPreferencesKey(name = "ACCESS_TOKEN_KEY")
    }
}