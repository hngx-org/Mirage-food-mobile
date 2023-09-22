package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.shegs.miragefood.ui.theme.Typography

@Composable
fun HeaderTitle(title: String, subtitle: String? = "") {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            title,
            style = Typography.bodyMedium.copy(
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.scrim,))
        Text(
            subtitle!!,
            style = Typography.bodySmall.copy(
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.scrim.copy(0.6f))
            )
    }
}