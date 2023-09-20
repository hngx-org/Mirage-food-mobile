package com.shegs.miragefood.ui.theme.free_lunch

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.seed
import com.shegs.miragefood.utils.AppTextField
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
                .padding(top = 100.dp, start = 12.dp, end = 12.dp),
        ) {
            Text(
                text = "Gift free lunch to",
                style = Typography.titleLarge.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                )
            )

            AppTextField(
                leadingIcon = R.drawable.icon_search,
                value = "",
                placeholder = "Search co-worker",
                onValueChanged = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(vertical = 20.dp)
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "*1 Free Lunch equates to ₦1,000 ",
                style = Typography.bodySmall.copy(
                    color = seed,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = 18.sp
                )

            )

            Row {

            }


        }
    }
}


@Preview
@Composable
fun PreviewFreeLunch() {
    FreeLunch()
}