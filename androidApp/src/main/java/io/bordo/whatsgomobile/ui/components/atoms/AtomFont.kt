package io.bordo.whatsgomobile.ui.components.atoms

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import io.bordo.whatsgomobile.R

val satoshiFamily = FontFamily(
    Font(R.font.satoshi_light, FontWeight.Light),
    Font(R.font.satoshi_light_italic, FontWeight.Light,FontStyle.Italic),

    Font(R.font.satoshi_regular, FontWeight.Normal),
    Font(R.font.satoshi_italic, FontWeight.Normal, FontStyle.Italic),

    Font(R.font.satoshi_medium, FontWeight.Medium),
    Font(R.font.satoshi_medium_italic, FontWeight.Medium, FontStyle.Italic),

    Font(R.font.satoshi_bold, FontWeight.Bold),
    Font(R.font.satoshi_bold_italic, FontWeight.Bold, FontStyle.Italic)
)
