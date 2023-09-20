package com.shegs.miragefood.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.ui.theme.seed


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetSate: SheetState,
    title: String,
    description: String,
    secondDescription: String,
) {
    ModalBottomSheet(sheetState = sheetSate, onDismissRequest = { /*TODO*/ }) {
        Text(text = title, style = Typography.bodyMedium.copy(fontWeight = FontWeight.W500))
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = description,
            style = Typography.bodySmall.copy(fontWeight = FontWeight.W400, color = grey3)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = secondDescription,
            style = Typography.bodyMedium.copy(fontWeight = FontWeight.W400, color = seed)
        )
        Spacer(modifier = Modifier.height(40.dp))
        RoundedCornerButton(text = "Close", onClick = {})

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    RoundedCornerButton(text = "Close", onClick = {})

}

