package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3

@Composable
fun FreeLunchTitle(title: String, subtitle: String? = "") {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(title, style = Typography.bodyMedium.copy(fontWeight = FontWeight.W500))
        Text(
            subtitle!!,
            style = Typography.bodySmall.copy(
                fontSize = 12.sp,
                color = grey3,
                fontWeight = FontWeight.W400
            )
        )
    }
}