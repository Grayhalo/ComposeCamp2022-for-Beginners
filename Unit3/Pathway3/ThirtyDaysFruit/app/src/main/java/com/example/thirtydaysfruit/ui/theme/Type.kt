package com.example.thirtydaysfruit.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysfruit.R

val MontSerrat_Alternates = FontFamily(
    Font(R.font.montserrat_alternates_regular),
    Font(R.font.montserrat_alternates_medium, FontWeight.Medium),
    Font(R.font.montserrat_alternates_bold, FontWeight.Bold)
)

val Sriracha = FontFamily(
    Font(R.font.sriracha_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */

    h1 = TextStyle(
        fontFamily = MontSerrat_Alternates,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    h2 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        fontFamily = MontSerrat_Alternates,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = MontSerrat_Alternates,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)