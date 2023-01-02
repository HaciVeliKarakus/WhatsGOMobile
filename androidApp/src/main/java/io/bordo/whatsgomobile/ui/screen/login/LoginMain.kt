package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.*
import io.bordo.whatsgomobile.ui.components.WGEmailBox
import io.bordo.whatsgomobile.ui.components.WGPasswordBox
import io.bordo.whatsgomobile.ui.theme.whatsappGreen


@Composable
fun LoginPage(
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit
) {
    Scaffold {
        LazyColumn(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                WGImage(id = R.drawable.logo_name_main)
                WGSpacer(height = 32.dp)
            }
            item {
                WGButton(
                    text = "Whatsapp ile Giriş",
                    iconId = R.drawable.ic_whatsapp_24,
                    backColor = whatsappGreen,
                    onClick = {}
                )
                WGSpacer()
                WGButton(
                    text = "Google ile Giriş",
                    iconId = R.drawable.ic_google,
                    textColor = Color.Black,
                    backColor = Color.White,
                    onClick = {}
                )
            }
            item {
                WGSpacer(height = 26.dp)
                WGDivider(centerText = "VEYA")
                WGSpacer(height = 26.dp)
            }
            item {
                WGEmailBox(hintText = "Mail Adresiniz")
                WGSpacer()
                WGPasswordBox(hintText = "Şifreniz")
                WGSpacer()
            }
            item {
                WGButton(
                    text = "Giriş Yap",
                    onClick = { onLoginClick() }
                )
                WGTextButton(
                    text = "Şifremi Unuttum",
                    onClick = onForgetClick
                )
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    LoginPage(
        onLoginClick = { },
        onForgetClick = { }
    )
}