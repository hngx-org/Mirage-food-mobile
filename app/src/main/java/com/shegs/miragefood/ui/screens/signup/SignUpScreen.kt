package com.shegs.miragefood.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.screens.signup.components.SignUpForm
import com.shegs.miragefood.ui.theme.MirageFoodTheme
import com.shegs.miragefood.utils.ValidationEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.validationEvents.collectLatest { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    navController.navigate(NestedNavItem.App.route) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }

    SignUpScreenContent(state = state, formEvent = viewModel::formEvent)
}

@Composable
fun SignUpScreenContent(
    state: SignUpFormState,
    formEvent: (SignUpFormEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Welcome on board !",
                    fontFamily = FontFamily(Font(R.font.poppins_black))
                )
                Text(
                    text = "Sign up to create an account",
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            }
        }

        item {
            SignUpForm(state = state, formEvent = { formEvent(it) })
        }

    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    MirageFoodTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignUpScreenContent(state = SignUpFormState(), formEvent = {})
        }
    }
}