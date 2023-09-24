package com.shegs.miragefood.ui.screens

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shegs.miragefood.ui.events.SearchScreenEvent
import com.shegs.miragefood.ui.events.SearchScreenUiEvents
import com.shegs.miragefood.ui.screens.common.RoundedSearchTextField
import com.shegs.miragefood.ui.screens.common.SearchScreenItem
import com.shegs.miragefood.ui.states.SearchScreenState
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.viewmodels.SearchViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is SearchScreenUiEvents.ShowSnackBar -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(event.message)
                    }
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
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
        SearchScreenContent(
            state = state,
            onEvent = viewModel::onEvent,
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        )
    }
}

@Composable
fun SearchScreenContent(
    state: SearchScreenState,
    onEvent: (SearchScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        RoundedSearchTextField(
            value = state.query,
            label = "Search co-worker",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onValueChange = { onEvent(SearchScreenEvent.SearchQueryChanged(it)) },
            onSearch = { onEvent(SearchScreenEvent.OnSearch) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box {
            if (state.loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (state.isSearching) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(state.searchResults) { user ->
                        SearchScreenItem(
                            user = user,
                            onClick = {
                                user.name?.let { SearchScreenEvent.OnItemClicked(it) }
                                    ?.let { onEvent(it) }
                            })
                    }
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "All users",
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(state.allUsers) { user ->
                            SearchScreenItem(
                                user = user,
                                onClick = {
                                    user.name?.let {
                                        SearchScreenEvent.OnItemClicked(
                                            it
                                        )
                                    }?.let { onEvent(it) }
                                })
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