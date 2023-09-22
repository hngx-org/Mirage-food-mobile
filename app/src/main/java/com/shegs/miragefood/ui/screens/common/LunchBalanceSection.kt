package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LunchBalanceSection(lunchBalance: String, subtitle: String? = "") {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = lunchBalance,
            fontWeight = FontWeight(500),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.scrim
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subtitle!!,
            fontWeight = FontWeight(400),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.scrim,
            modifier = Modifier
                .alpha(0.6f)
        )
    }
}