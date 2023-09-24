package com.shegs.miragefood.ui.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.screens.common.AppTextField
import com.shegs.miragefood.ui.screens.common.BottomSheet
import com.shegs.miragefood.ui.screens.common.HeaderTitle
import com.shegs.miragefood.ui.screens.common.RoundedCornerButton
import com.shegs.miragefood.ui.screens.common.TextFieldHeader
import com.shegs.miragefood.ui.screens.common.TopNavigationBar
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.seed
import com.shegs.miragefood.ui.theme.seedWithOpacity
import com.shegs.miragefood.utils.CounterText
import com.shegs.miragefood.viewmodels.GiftLunchViewModel

@OptIn(
    ExperimentalMaterial3Api::class
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GiftLunch(giftLunchViewModel: GiftLunchViewModel = hiltViewModel(), navController: NavController) {

    var showModalBottomSheet = giftLunchViewModel.showBottomSheet.collectAsState()
    val sheetState = rememberModalBottomSheetState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopNavigationBar(
                navController = navController,
                onBackButtonPressed = {})
        }
    ) {

        var search by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }
        var count by remember { mutableIntStateOf(1) }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp, start = 20.dp, end = 20.dp),

            ) {
            HeaderTitle(title = "20 Free Lunch", subtitle = "Your Free Lunch Redeemed Balance ")
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Gift free lunch to",
                style = Typography.titleLarge.copy(
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 24.sp
                ),
                modifier = Modifier.padding(start = 4.dp),

                )

            AppTextField(
                placeholderComposable = null,
                leadingIcon = R.drawable.icon_search,
                value = search,
                placeholder = "Search co-worker",
                onValueChanged = {
                    if (it != null) {
                        search = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(vertical = 20.dp)
            )



            Text(
                modifier = Modifier.padding(top = 8.dp, start = 1.dp),
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
                    .padding(vertical = 20.dp, horizontal = 2.dp),
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
                        value = name,
                        placeholder = "Ken Adams",
                        onValueChanged = {
                            if (it != null) {
                                name = it
                            }
                        },
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
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                ) {
                                    IconButton(onClick = { count++ }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_add),
                                            contentDescription = "add"
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    CounterText(count = count.toString())
                                    Spacer(modifier = Modifier.width(5.dp))
                                    IconButton(onClick = { if (count > 0) {
                                        count--
                                    } }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.icon_minus),
                                            contentDescription = "remove"
                                        )
                                    }
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
                    .padding(vertical = 10.dp, horizontal = 2.dp),
            ) {
                TextFieldHeader(header = "Message")
                Spacer(modifier = Modifier.height(6.dp))
                AppTextField(
                    containerColor = seedWithOpacity,
                    value = message,
                    placeholderComposable = null,
                    placeholderColor = seed,
                    placeholder = "I know you were nervous at the presentation\n" +
                            "this morning. You killed it though !",
                    onValueChanged = {
                        if (it != null) {
                            message = it
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )

            }

            Spacer(modifier = Modifier.height(20.dp))


            if (showModalBottomSheet.value) {
                BottomSheet(
                    emojiUnicode = 0x1F601,
                    sheetState = sheetState,
                    title = "Nicely done!",
                    description = "You’ve just brightened Ken Adam’s day\nwith a free lunch ",
                    secondDescription = "You're a good sport!"
                ) {
                    giftLunchViewModel.setShowBottomSheet(showBottomSheet = false)
                }
            }


            RoundedCornerButton(text = "Send Free Lunch", onClick = {
                giftLunchViewModel.setShowBottomSheet(true)
            })

        }


    }

}
