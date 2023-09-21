package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shegs.miragefood.models.datas.UserData
import com.shegs.miragefood.models.repositories.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class UserViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    private val _userData = MutableStateFlow<UserData?>(null)
    val userData: StateFlow<UserData?> = _userData

    init {
        viewModelScope.launch {
            userDataRepository.getUserData().collect { data ->
                _userData.value = data
            }
        }
    }
}