package com.shegs.miragefood.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.theme.MirageFoodTheme


@Composable
fun RedeemFreeLunchScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RedeemLunchTopAppBar(
            title = stringResource(id = R.string.redeem_free_lunch),
            onBackPressed = {}
        )
        Text(
            text = "\uD83C\uDF89",
            modifier = Modifier,
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        RedeemLunchDescriptionSection(
            name = "Esther",
            amount = 2,
            description = "Thank you for helping me with my documentation today, You’re so sweet !"
        )
        Spacer(modifier = Modifier.height(20.dp))
        RowButtons(
            onClose = { },
            onRedeem = { }
        )
        Spacer(modifier = Modifier.height(90.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun RedeemFreeLunchPreview(){
    MirageFoodTheme {
        RedeemFreeLunchScreen()
    }
}




@Composable
fun RedeemLunchTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackPressed: ()->Unit
){
    Column(
        modifier = modifier
            .padding(vertical = 16.dp)
    ) {
        IconButton(
            onClick = onBackPressed
        ) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "back icon")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 27.sp
        )
    }
}

@Composable
fun RowButtons(
    onClose: ()->Unit,
    onRedeem:()->Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Button(
            onClick = onRedeem,
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Redeem for cash")
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onClose,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6F61)
            )
        ) {
            Text(text = "Close")
        }
    }
}

@Composable
fun RedeemLunchDescriptionSection(
    name: String,
    amount: Int,
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.you_were_sent_free_lunch),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.outline,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight.W500
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.amount),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.outline,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "$amount Free Lunch",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(id = R.string.description),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.outline,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ){
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.W400
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "❤️",
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.outline,
                    )
                ){
                    append(stringResource(id = R.string.your_free_lunch_will_be_redeemed))
                }
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary
                    )
                ){
                    append(stringResource(id = R.string.fre_lunch_equals))
                }
            },
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}