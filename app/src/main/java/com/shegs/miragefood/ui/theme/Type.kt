package com.shegs.miragefood.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.R

// Set of Material typography styles to start with

val Poppins = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular, FontWeight.Normal),

    )

val Typography = Typography(


    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontSize = 24.sp,
        lineHeight = 36.sp
    ),


    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontSize = 18.sp,
        lineHeight = 21.sp
    ),

    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )

)