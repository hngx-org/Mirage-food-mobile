package com.shegs.miragefood.ui.states

import com.shegs.miragefood.models.datas.CoWorker

data class SearchScreenState(
    val query: String = "",
    val isSearching: Boolean = false,
    val recentSearches: List<CoWorker> = emptyList(),
)
