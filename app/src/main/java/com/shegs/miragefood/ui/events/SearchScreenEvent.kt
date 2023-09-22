package com.shegs.miragefood.ui.events

sealed interface SearchScreenEvent {
    object SearchClicked : SearchScreenEvent

    object CoWorkerCardClicked : SearchScreenEvent
    data class SearchQueryChanged(val query: String) : SearchScreenEvent
}