package com.shegs.miragefood.ui.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.seed
import com.shegs.miragefood.ui.theme.seedWithOpacity
import com.shegs.miragefood.utils.AppTextField
import com.shegs.miragefood.utils.CounterText
import com.shegs.miragefood.utils.RoundedCornerButton
import com.shegs.miragefood.utils.TextFieldHeader
import com.shegs.miragefood.utils.TopNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                placeholderComposable = null,
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    TextFieldHeader(header = "Name")
                    Spacer(modifier = Modifier.height(6.dp))
                    AppTextField(
                        placeholderComposable = null,
                        containerColor = seedWithOpacity,
                        placeholderColor = seed,
                        value = "",
                        placeholder = "Ken Adams",
                        onValueChanged = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    TextFieldHeader(header = "Free Lunch")
                    Spacer(modifier = Modifier.height(6.dp))
                    AppTextField(
                        containerColor = seedWithOpacity,
                        value = "",
                        onValueChanged = {},
                        placeholderComposable = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_add),
                                        contentDescription = "add"
                                    )
                                }
                                Spacer(modifier = Modifier.width(5.dp))
                                CounterText(count = "2")
                                Spacer(modifier = Modifier.width(5.dp))
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_minus),
                                        contentDescription = "remove"
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 10.dp),
            ) {
                TextFieldHeader(header = "Message")
                Spacer(modifier = Modifier.height(6.dp))
                AppTextField(
                    containerColor = seedWithOpacity,
                    value = "",
                    placeholderComposable = null,
                    placeholderColor = seed,
                    placeholder = "I know you were nervous at the presentation\n" +
                            "this morning. You killed it though !",
                    onValueChanged = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            RoundedCornerButton(text = "Send Free Lunch") {

            }



        }
        Spacer(modifier = Modifier.height(100.dp))



    }
}


@Preview
@Composable
fun PreviewFreeLunch() {
    FreeLunch()
}