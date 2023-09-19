package com.shegs.miragefood.ui.theme.free_lunch

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.utils.TopNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeLunch() {
    Scaffold(
        topBar = {
            TopNavigationBar(
                title = "₦20,000",
                subtitle = "Your Free Lunch Redeemed Balance",
                onBackButtonPressed = {})
        }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, start = 12.dp),
        ) {
            Text(
                text = "Gift free lunch to",
                style = Typography.titleLarge.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
            )





        }
    }
}


@Preview
@Composable
fun PreviewFreeLunch() {
    FreeLunch()
}