package com.shegs.miragefood.ui.screens.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3

@Composable
fun TextFieldHeader(header: String) {
    Text(
        header,
        style = Typography.bodySmall.copy(
            fontWeight = FontWeight.W400,
            lineHeight = 18.sp,
            color = grey3
        )
    )
}