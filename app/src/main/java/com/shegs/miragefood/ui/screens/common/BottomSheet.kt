package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.ui.theme.seed
import com.shegs.miragefood.utils.EmojiByUnicode


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    title: String,
    emojiUnicode: Int,
    description: String,
    secondDescription: String,
    onButtonClicked: () -> Unit,
) {

    ModalBottomSheet(sheetState = sheetState, onDismissRequest = { /*TODO*/ }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
        ) {
            EmojiByUnicode(
                emojiUnicode = emojiUnicode,
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = title, style = Typography.bodyMedium.copy(fontWeight = FontWeight.W500))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = description,
                style = Typography.bodySmall.copy(fontWeight = FontWeight.W400, color = grey3)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = secondDescription,
                style = Typography.bodySmall.copy(fontWeight = FontWeight.W400, color = seed)
            )
            Spacer(modifier = Modifier.height(40.dp))
            RoundedCornerButton(text = "Close", onClick = onButtonClicked)
            Spacer(modifier = Modifier.height(46.dp))
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    if (showBottomSheet) {
        BottomSheet(
            emojiUnicode = 0x1F601,
            sheetState = sheetState,
            title = "Nicely done!",
            description = "You’ve just brightened Ken Adam’s day\nwith a free lunch ",
            secondDescription = "You're a good sport!"
        ) {
            showBottomSheet = false
        }
    }
    RoundedCornerButton(text = "Close", onClick = {
        showBottomSheet = true
    })

}

