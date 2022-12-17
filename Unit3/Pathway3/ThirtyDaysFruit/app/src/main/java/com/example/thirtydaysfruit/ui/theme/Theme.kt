package com.example.thirtydaysfruit.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
//    primary = Purple200,
//    primaryVariant = Purple700,
//    secondary = Teal200
    background = OrangeGreen700,
    surface = Orange100,
    primary = OrangeGreen500,
    onPrimary = Yellow20,
    secondary = Yellow50,
    onSurface = Yellow20,
)

private val LightColorPalette = lightColors(

    background = Grey100,
    surface = Grey50,
    primary = Yellow100,
    onPrimary = BlueGrey900,
    secondary = Orange200,
    onSurface = BlueGrey900,

//    primary = Purple500,
//    primaryVariant = Purple700,
//    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ThirtyDaysFruitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}