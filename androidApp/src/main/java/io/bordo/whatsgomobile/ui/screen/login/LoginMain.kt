package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.atoms.*
import io.bordo.whatsgomobile.ui.components.widgets.WidgetEmailBox
import io.bordo.whatsgomobile.ui.components.widgets.WidgetPasswordBox
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
                AtomImage(id = R.drawable.logo_name_main)
                AtomSpacer(height = 32.dp)
            }
            item {
                AtomButton(
                    text = "Whatsapp ile Giriş",
                    iconId = R.drawable.ic_whatsapp_24,
                    backColor = whatsappGreen,
                    onClick = {}
                )
                AtomSpacer()
                AtomButton(
                    text = "Google ile Giriş",
                    iconId = R.drawable.ic_google,
                    textColor = Color.Black,
                    backColor = Color.White,
                    onClick = {}
                )
            }
            item {
                AtomSpacer(height = 26.dp)
                AtomDivider(centerText = "VEYA")
                AtomSpacer(height = 26.dp)
            }
            item {
                WidgetEmailBox(hintText = "Mail Adresiniz")
                AtomSpacer()
                WidgetPasswordBox(hintText = "Şifreniz")
                AtomSpacer()
            }
            item {
                AtomButton(
                    text = "Giriş Yap",
                    onClick = { onLoginClick() }
                )
                AtomTextButton(
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