package com.shegs.miragefood.ui.events

sealed interface SearchScreenEvent {
    object OnSearch : SearchScreenEvent
    data class OnItemClicked(val name: String) : SearchScreenEvent
    data class SearchQueryChanged(val query: String) : SearchScreenEvent
}