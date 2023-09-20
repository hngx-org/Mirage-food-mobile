package com.shegs.miragefood.utils

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(

    useCancelButton: Boolean? = false,
    onBackButtonPressed: () -> Unit
) {
    TopAppBar(
        title = {

        },
        navigationIcon = {
            IconButton(onClick = onBackButtonPressed) {
                val icon = if (!useCancelButton!!) {
                    painterResource(id = R.drawable.icon_back)
                } else {
                    painterResource(id = R.drawable.icon_close)
                }
                Icon(
                    painter = icon,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(15.dp)
                )

            }
        },
    )
}

@Preview
@Composable
fun Preview() {
    TopNavigationBar() {

    }
}