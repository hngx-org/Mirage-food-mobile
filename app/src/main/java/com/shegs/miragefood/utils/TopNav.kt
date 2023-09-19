package com.shegs.miragefood.utils

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.shegs.miragefood.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(text: String, onBackButtonPressed: () -> Unit) {
    TopAppBar(
        title = {
            Text(text, style = Typography.titleLarge.copy(fontWeight = FontWeight.W500))
        },
        navigationIcon = {
            IconButton(onClick = onBackButtonPressed) {
                Icon(Icons.Filled.ArrowBack, "arrow back")
            }
        },
    )
}

@Preview
@Composable
fun Preview() {
    TopNavigationBar(text = "20,000") {

    }
}