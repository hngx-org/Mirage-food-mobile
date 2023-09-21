package com.shegs.miragefood.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.seed

@Composable
fun CounterText(count: String) {
    Text(
        text = count,
        style = Typography.bodySmall.copy(fontWeight = FontWeight.W400, color = seed)
    )
}