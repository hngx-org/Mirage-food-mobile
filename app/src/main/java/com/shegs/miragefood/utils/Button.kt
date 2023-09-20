package com.shegs.miragefood.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.md_theme_light_onPrimary
import com.shegs.miragefood.ui.theme.seed

@Composable
fun RoundedCornerButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = seed
        )
    ) {
        Text(
            text = text,
            style = Typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = md_theme_light_onPrimary
            )
        )
    }
}


@Preview()
@Composable
fun RoundedCornerButtonDemo() {
    RoundedCornerButton(
        text = "Click Me",
        onClick = {
            // Handle button click here
        }
    )
}

