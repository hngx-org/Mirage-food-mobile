package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.network.data.Result
import com.shegs.miragefood.network.data.SignUpRequest
import com.shegs.miragefood.network.data.SignUpResponse
import com.shegs.miragefood.repositories.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpRepository: SignUpRepository) : ViewModel() {

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _signUpResult = MutableStateFlow<Result<SignUpResponse>>(Result.Loading)
    val signUpResult: StateFlow<Result<SignUpResponse>> = _signUpResult.asStateFlow()

    fun signUp(email: String, firstName: String, lastName: String, password: String, phoneNumber: String) {
        _loading.value = true // Start loading
        val signUpRequest = SignUpRequest(email, firstName, lastName, password, phoneNumber)

        viewModelScope.launch {
            try {
                val response = signUpRepository.signUp(signUpRequest)
                when (response) {
                    is Result.Success -> {
                        // Extract the data from the response and emit it as success
                        val signUpResponse = response.data
                        _signUpResult.emit(Result.Success(signUpResponse))
                        _loading.value = false // Stop loading
                    }
                    is Result.Error -> {
                        // Emit the error result as-is
                        _signUpResult.emit(Result.Error(response.message))
                        _loading.value = false // Stop loading
                    }

                    else -> {}
                }
            } catch (e: Exception) {
                _signUpResult.emit(Result.Error("Sign-up failed. Please try again."))
                _loading.value = false // Stop loading
            }
        }
    }
}






