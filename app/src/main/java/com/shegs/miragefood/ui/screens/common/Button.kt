package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.shegs.miragefood.ui.theme.seedWithOpacity

@Composable
fun RoundedCornerButton(
    text: String,
    usePlainButton: Boolean? = false,
    onClick: () -> Unit
) {
    if (!usePlainButton!!){
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(2.dp)
                .height(60.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White

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
    }else{
        Button(
            border =BorderStroke(1.dp, seed),
            onClick = onClick,
            modifier = Modifier
                .padding(2.dp)
                .height(60.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White

            )
        ) {
            Text(
                text = text,
                style = Typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = seed
                )
            )
        }
    }

}
@Composable
fun SmallButton(text:String, onClick: () -> Unit){
    Button(
        border =BorderStroke(1.dp, seed),
        onClick = onClick,
        modifier = Modifier
            .padding(2.dp)
            .height(50.dp)
            .width(220.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = seedWithOpacity

        )
    ) {
        Text(
            text = text,
            style = Typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = seed
            )
        )
    }
}


@Preview()
@Composable
fun RoundedCornerButtonDemo() {
    RoundedCornerButton(
        usePlainButton = true,
        text = "Click Me",
        onClick = {
            // Handle button click here
        }
    )
}
