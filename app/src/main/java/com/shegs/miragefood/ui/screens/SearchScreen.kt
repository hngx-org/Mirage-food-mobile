package com.shegs.miragefood.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shegs.miragefood.ui.events.SearchScreenEvent
import com.shegs.miragefood.ui.screens.common.CoWorkerCard
import com.shegs.miragefood.ui.screens.common.RoundedSearchTextField
import com.shegs.miragefood.ui.states.SearchScreenState
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.viewmodels.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    SearchScreenContent(state = state, onEvent = viewModel::onEvent)
}

@Composable
fun SearchScreenContent(
    state: SearchScreenState,
    onEvent: (SearchScreenEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Search for a Co-worker",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                ),
        ) {
            RoundedSearchTextField(
                value = state.query,
                label = "Search co-worker",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onValueChange = { onEvent(SearchScreenEvent.SearchQueryChanged(it)) },
                onSearch = { onEvent(SearchScreenEvent.SearchClicked) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (state.isSearching) {
                AnimatedVisibility(visible = true) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(top = 16.dp)
                    ) {

                    }
                }
            } else {
                Column {
                    Text(
                        text = "Recent searches",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                    )
                    AnimatedVisibility(visible = true) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(top = 16.dp)
                        ) {
                            items(state.recentSearches) { coWorker ->
                                CoWorkerCard(
                                    coWorker = coWorker,
                                    onClick = { onEvent(SearchScreenEvent.CoWorkerCardClicked) })
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    MirageFoodTheme {
        SearchScreenContent(state = SearchScreenState(), onEvent = {})
    }
}