package com.shegs.miragefood.ui.screens.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.navigations.NestedNavItem
import com.shegs.miragefood.ui.screens.signin.components.SignInForm
import com.shegs.miragefood.utils.ValidationEvent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignInScreen(navController: NavController, viewModel: SignInViewModel = hiltViewModel()) {


    LaunchedEffect(key1 = true) {
        viewModel.validationEvents.collectLatest { event ->
            when (event) {
                ValidationEvent.Success -> {
                    navController.navigate(NestedNavItem.App.route) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }

    val state = viewModel.state.collectAsState().value

    SignInScreenContent(state = state, formEvent = viewModel::formEvent)
}

@Composable
fun SignInScreenContent(
    state: SignInFormState,
    formEvent: (SignInFormEvent) -> Unit
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
                    text = "Welcome back !",
                    fontFamily = FontFamily(Font(R.font.poppins_black))
                )
                Text(
                    text = "Sign in to access your account",
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            }
        }

        item {
            SignInForm(state = state, formEvent = { formEvent(it) })
        }

    }
}

