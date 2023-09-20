package com.shegs.miragefood.screens.redeemFreeLunch.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.MirageFoodTheme


@Composable
fun BottomSheetContent(
    emoji: String,
    header: String,
    description: String,
    message: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = emoji,
            modifier = Modifier,
            fontSize = 60.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = header,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W500,
            lineHeight = 27.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.outline,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.W400
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.W400
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = onClose,

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Close")
        }
        Spacer(modifier = Modifier.height(40.dp))

    }
}

@Preview
@Composable
fun BottomSheetContentPreview(){
    MirageFoodTheme {
        BottomSheetContent(
            emoji = "\uD83E\uDD73",
            header = "Congratulations !",
            description = "You have redeemed your 2 free lunch gift from esther",
            message = "Have fun !",
            onClose = {  }
        )
    }
}
