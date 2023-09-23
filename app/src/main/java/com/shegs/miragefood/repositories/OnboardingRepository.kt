package com.shegs.miragefood.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.shegs.miragefood.models.datas.OnboardingItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OnboardingRepository @Inject constructor(
    private val onboardingDatastorePreferences: DataStore<Preferences>,
) {

    private val _onboardingItems = MutableStateFlow<List<OnboardingItems>>(emptyList())
    val onboardingItems: StateFlow<List<OnboardingItems>> = _onboardingItems

    init {
        // Fetch or load data from an actual data source here
        // For simplicity, you can use your sample data here
        _onboardingItems.value = listOf(
            OnboardingItems.First,
            OnboardingItems.Second,
            OnboardingItems.Third
        )
    }

    suspend fun saveOnBoardingState(isOnBoarded: Boolean) {
        onboardingDatastorePreferences.edit { preferences ->
            preferences[ON_BOARDING_KEY] = isOnBoarded
        }
    }

    suspend fun saveLoginDataStorePreferences(access: String) {
        onboardingDatastorePreferences.edit {
            it[LOGIN_DATA_KEY] = access
        }
        Log.i("access saved", access)
    }

    fun readLoginData(): Flow<String> {
        return onboardingDatastorePreferences.data
            .catch { exception ->
                if (exception is Exception) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                val loginData = preferences[LOGIN_DATA_KEY] ?: ""
                loginData
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
        val LOGIN_DATA_KEY = stringPreferencesKey(
            name = "LOGIN_DATA_KEY"
        )
    }
}