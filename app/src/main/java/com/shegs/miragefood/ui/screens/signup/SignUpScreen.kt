package com.shegs.miragefood.ui.screens.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shegs.miragefood.ui.screens.common.CustomRoundedButton
import com.shegs.miragefood.ui.screens.common.RoundedTextField
import com.shegs.miragefood.ui.theme.MirageFoodTheme

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    SignUpScreenContent(onEvent = viewModel::onEvent)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenContent(
    onEvent: (SignUpEvents) -> Unit
) {

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Welcome on board !",
                    fontWeight = FontWeight(500),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.scrim
                )
                Text(
                    text = "Sign up to create an account",
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Name",
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                RoundedTextField(
                    value = fullName,
                    label = "Full Name",
                    icon = Icons.Outlined.Person,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { fullName = it }
                )
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Email Address",
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                RoundedTextField(
                    value = email,
                    label = "Email",
                    icon = Icons.Outlined.Email,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { email = it }
                )
            }
        }

        item {
            var passwordVisibility by remember {
                mutableStateOf(false)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Password",
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Password",
                            fontWeight = FontWeight(400),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                        )
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
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = MaterialTheme.shapes.medium,
                    maxLines = 1,
                    singleLine = true,
                )
            }
        }

        item {
            var passwordVisibility by remember {
                mutableStateOf(false)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Confirm Password",
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                )
                Spacer(modifier = Modifier.height(6.dp))
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Confirm Password",
                            fontWeight = FontWeight(400),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                        )
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
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text(
                        text = "Remember Password",
                        fontWeight = FontWeight(400),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.scrim.copy(0.6f)
                    )
                }
            }
        }

        item {
            CustomRoundedButton(
                label = "Sign Up",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                filled = true,
                onClick = {
                    onEvent(SignUpEvents.OnSignUpClicked)
                }
            )
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
            SignUpScreenContent(onEvent = {})
        }
    }
}