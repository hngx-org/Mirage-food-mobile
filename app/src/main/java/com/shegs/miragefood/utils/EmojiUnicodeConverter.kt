package com.shegs.miragefood.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun EmojiByUnicode(emojiUnicode: Int, modifier: Modifier = Modifier) {
    val emojiString = remember(emojiUnicode) { String(Character.toChars(emojiUnicode)) }

    Text(text = emojiString, style = TextStyle(
        fontSize = 32.sp
    ))
}