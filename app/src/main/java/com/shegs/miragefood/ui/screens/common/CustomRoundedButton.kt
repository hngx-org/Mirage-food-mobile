package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomRoundedButton(
    label: String,
    modifier: Modifier = Modifier,
    filled: Boolean = false,
    onClick: () -> Unit
) {

    val (containerColor, contentColor, borderColor) = when (filled) {
        true -> {
            Triple(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.onPrimary,
                MaterialTheme.colorScheme.primary
            )
        }

        false -> {
            Triple(
                MaterialTheme.colorScheme.background,
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.primary
            )
        }
    }

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Text(
            text = label,
            modifier = Modifier
                .padding(vertical = 8.dp),
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}