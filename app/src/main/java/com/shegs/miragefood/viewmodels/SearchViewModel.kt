package com.shegs.miragefood.viewmodels

import androidx.lifecycle.ViewModel
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.CoWorker
import com.shegs.miragefood.ui.events.SearchScreenEvent
import com.shegs.miragefood.ui.states.SearchScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                recentSearches = listOf(
                    CoWorker(
                        name = "Ayodeji Musa",
                        profilePicture = R.drawable.coworker_1,
                        department = "HR Department"
                    ),
                    CoWorker(
                        name = "Bisola Dabo",
                        profilePicture = R.drawable.coworker_2,
                        department = "Marketing Department"
                    ),
                )
            )
        }
    }

    fun onEvent(event: SearchScreenEvent) {
        when (event) {
            SearchScreenEvent.SearchClicked -> {
                _state.update { it.copy(isSearching = true) }
            }

            is SearchScreenEvent.SearchQueryChanged -> {
                _state.update { it.copy(query = event.query) }
            }

            SearchScreenEvent.CoWorkerCardClicked -> {
                // ToDO()
            }
        }
    }
}