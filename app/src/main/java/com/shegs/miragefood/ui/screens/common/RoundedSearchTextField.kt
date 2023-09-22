package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedSearchTextField(
    value: String,
    label: (String),
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit
) {

    val focsManager = LocalFocusManager.current

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        label = {
            Text(
                text = label,
                fontWeight = FontWeight(400),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.scrim.copy(0.6f)
            )
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = label)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focsManager.clearFocus()
                onSearch()
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