package com.shegs.miragefood.utils

import android.graphics.drawable.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.shegs.miragefood.ui.theme.grey


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(leadingIcon: ImageVector? = null, value: String, onValueChanged: (String?) -> Unit) {
    OutlinedTextField(
        leadingIcon = {
            Icon(
                imageVector = leadingIcon!!,
                tint = grey,
                contentDescription = "leading icon",
            )
        },
        value = value,
        onValueChange = onValueChanged,
    )
}

@Preview
@Composable
fun PreviewTextField() {
    TextField()
}