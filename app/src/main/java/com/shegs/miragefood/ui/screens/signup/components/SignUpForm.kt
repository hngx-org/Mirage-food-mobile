package com.shegs.miragefood.ui.screens.signup.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.screens.common.CustomRoundedButton
import com.shegs.miragefood.ui.screens.common.RoundedTextField
import com.shegs.miragefood.ui.screens.signup.SignUpFormEvent
import com.shegs.miragefood.ui.screens.signup.SignUpFormState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpForm(
    state: SignUpFormState,
    formEvent: (SignUpFormEvent) -> Unit,
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
                text = "Name",
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
            Spacer(modifier = Modifier.height(6.dp))
            RoundedTextField(
                value = state.fullName,
                label = "Full Name",
                icon = Icons.Outlined.Person,
                modifier = Modifier.fillMaxWidth(),
                error = state.fullNameError != null,
                onValueChange = { formEvent(SignUpFormEvent.FullNameChanged(it)) }
            )
            state.fullNameError?.let { errorMessage ->
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
                onValueChange = { formEvent(SignUpFormEvent.EmailChanged(it)) }
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
                onValueChange = { formEvent(SignUpFormEvent.PasswordChanged(it)) },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password", fontFamily = FontFamily(Font(R.font.poppins_light)))
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)
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
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Next)
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
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Confirm Password",
                fontFamily = FontFamily(Font(R.font.poppins_light))
            )
            Spacer(modifier = Modifier.height(6.dp))
            TextField(
                value = state.repeatedPassword,
                onValueChange = { formEvent(SignUpFormEvent.RepeatedPasswordChanged(it)) },
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
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = MaterialTheme.shapes.medium,
                maxLines = 1,
                singleLine = true,
            )
            state.repeatedPasswordError?.let { errorMessage ->
                AnimatedVisibility(visible = true) {
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.rememberPassword,
                    onCheckedChange = { formEvent(SignUpFormEvent.RememberPassword(it)) })
                Text(
                    text = "Remember Password",
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                )
            }
        }
        CustomRoundedButton(
            label = "Sign Up",
            modifier = Modifier.fillMaxWidth(),
            filled = true,
            onClick = {
                formEvent(SignUpFormEvent.OnSignUpClicked)
            }
        )
    }
}