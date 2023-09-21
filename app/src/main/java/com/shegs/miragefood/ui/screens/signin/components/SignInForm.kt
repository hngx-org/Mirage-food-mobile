package com.shegs.miragefood.ui.screens.signin.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.screens.common.CustomRoundedButton
import com.shegs.miragefood.ui.screens.common.RoundedTextField
import com.shegs.miragefood.ui.screens.signin.SignInFormEvent
import com.shegs.miragefood.ui.screens.signin.SignInFormState
import com.shegs.miragefood.ui.theme.MirageFoodTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInForm(
    state: SignInFormState,
    formEvent: (SignInFormEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Email Address",
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
            Spacer(modifier = Modifier.height(6.dp))
            RoundedTextField(
                value = state.email,
                label = "Email",
                icon = Icons.Outlined.Email,
                error = state.emailError != null,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { formEvent(SignInFormEvent.EmailChanged(it)) }
            )
            state.emailError?.let { errorMessage ->
                AnimatedVisibility(visible = true) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Password",
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
            Spacer(modifier = Modifier.height(6.dp))
            TextField(
                value = state.password,
                onValueChange = { formEvent(SignInFormEvent.PasswordChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password", fontFamily = FontFamily(Font(R.font.poppins_light)))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "confirm password"
                    )
                },
                trailingIcon = {
                    val icon =
                        if (passwordVisibility) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = icon, contentDescription = null)
                    }
                },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                ),
                isError = state.passwordError != null,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.medium,
                maxLines = 1,
                singleLine = true,
            )
            state.passwordError?.let { errorMessage ->
                AnimatedVisibility(visible = true) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
        CustomRoundedButton(
            label = "Sign In",
            modifier = Modifier.fillMaxWidth(),
            filled = true,
            onClick = {
                formEvent(SignInFormEvent.SignInClicked)
            }
        )
    }

}

@Preview
@Composable
fun SignInFormPreview() {
    MirageFoodTheme {
        SignInForm(state = SignInFormState(), formEvent = {})
    }
}