package io.bordo.whatsgomobile.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColors(
    primary = maroon200,
    primaryVariant = maroon700,
    secondary = teal200,
    background = black,
    surface = softBlack,
    error = red,
    onPrimary = white,
    onSecondary = black,
    onBackground = white,
    onSurface = white,
    onError = white
)

private val LightColorPalette = lightColors(
    primary = PurpleMain,
    primaryVariant = maroon700,
    secondary = teal200,
    secondaryVariant = teal700,
    background = GrayBackground,
    surface = WhiteMain,
    error = red,
    onPrimary = white,
    onSecondary = black,
    onBackground = black,
    onSurface = black,
    onError = white
)

@Composable
fun WhatsGOMobileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(colors = colors, content = content)
}