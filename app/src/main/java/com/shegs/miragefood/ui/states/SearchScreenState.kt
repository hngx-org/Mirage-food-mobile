package com.shegs.miragefood.ui.states

import com.shegs.miragefood.services.UserInfo

data class SearchScreenState(
    val allUsers: List<UserInfo> = emptyList(),
    val searchResults: List<UserInfo> = emptyList(),
    val query: String = "",
    val loading: Boolean = false,
    val isSearching: Boolean = false
)
