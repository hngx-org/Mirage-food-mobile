package com.shegs.miragefood.utils

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    title: String,
    subtitle: String? = "",
    useCancelButton: Boolean? = false,
    onBackButtonPressed: () -> Unit
) {
    TopAppBar(
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp)
            ) {
                Text(title, style = Typography.titleLarge.copy(fontWeight = FontWeight.W500))
                Text(
                    subtitle!!,
                    style = Typography.bodySmall.copy(
                        fontSize = 12.sp,
                        color = grey,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onBackButtonPressed) {
                if (!useCancelButton!!) Icon(Icons.Filled.ArrowBack, "arrow back")
                else Icon(Icons.Filled.Close, "arrow back")
            }
        },
    )
}

@Preview
@Composable
fun Preview() {
    TopNavigationBar(title = "20,000", subtitle = "Your Free Lunch Redeemed Balance") {

    }
}