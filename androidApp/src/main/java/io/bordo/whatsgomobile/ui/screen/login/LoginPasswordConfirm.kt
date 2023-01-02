package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.WGButton
import io.bordo.whatsgomobile.ui.components.WGSpacer
import io.bordo.whatsgomobile.ui.components.WGText
import io.bordo.whatsgomobile.ui.components.WGTopAppBar
import io.bordo.whatsgomobile.ui.components.WGPasswordBox
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun PasswordConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Scaffold(topBar = { WGTopAppBar(onBackClick = onBackClick) }) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    WGText(
                        text = "Yeni Şifre Belirle",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    WGSpacer(8.dp)
                    WGText(
                        text = "WhatsGO hesabınız için yeni bir şifre belirleyin.",
                        color = GrayMain
                    )
                    WGSpacer(24.dp)
                }
            }
            item {
                WGPasswordBox(hintText = "Şifre")
                WGSpacer()
                WGPasswordBox(hintText = "Şifre tekrar")
                WGSpacer()
            }
            item {
                WGButton(
                    text = "Devam Et",
                    onClick = onConfirmClick
                )
                WGSpacer()
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    PasswordConfirm(onBackClick = {}) {

    }
}