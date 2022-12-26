package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.*
import io.bordo.whatsgomobile.ui.components.edittext.WGEmailBox
import io.bordo.whatsgomobile.ui.theme.whatsappGreen


@Composable
fun LoginPage(
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit
) {
    Scaffold(
        topBar = { BackSection(onBackClick = {}) }
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                WGLogo(bottomSpacer = 32.dp)
            }
            item {
                WGButton(
                    text = "Whatsapp ile Giriş",
                    iconId = R.drawable.ic_whatsapp_24,
                    backColor = whatsappGreen,
                    bottomSpacer = 16.dp,
                    onClick = {}
                )
                WGButton(
                    text = "Google ile Giriş",
                    R.drawable.ic_google,
                    textColor = Color.Black,
                    backColor = Color.White,
                    bottomSpacer = 16.dp,
                    onClick = {}
                )
            }
            item {
                WGDivider(
                    centerText = "VEYA",
                    topSpacer = 26.dp,
                    bottomSpacer = 26.dp
                )
            }
            item {
                WGEmailBox()
                WGPasswordBox(bottomSpace = 32.dp)
            }
            item {
                WGButton(
                    text = "Giriş Yap",
                    onClick = { onLoginClick() },
                    bottomSpacer = 16.dp
                )
                TextButton(
                    onClick = { onForgetClick() },
                ) {
                    Text(text = "Şifremi Unuttum")
                }
                Spacer16H()
            }
        }
    }
}





