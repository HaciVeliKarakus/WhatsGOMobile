package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.WGButton
import io.bordo.whatsgomobile.ui.components.WGSpacer
import io.bordo.whatsgomobile.ui.components.WGText
import io.bordo.whatsgomobile.ui.components.WGTopAppBar
import io.bordo.whatsgomobile.ui.components.WGEmailBox
import io.bordo.whatsgomobile.ui.theme.GrayBackground
import io.bordo.whatsgomobile.ui.theme.GrayMain


@Composable
fun MailConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Scaffold(
        topBar = { WGTopAppBar(onBackClick = onBackClick) },
        backgroundColor = GrayBackground
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    WGText(
                        text = "Şifremi Unuttum",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    WGSpacer()
                    WGText(
                        text = "E-posta adresinizi aşağıya yazın, size şifrenizi sıfırlamanız için bir bağlantı göndereceğiz.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = GrayMain,
                    )
                    WGSpacer(height = 24.dp)
                }
            }
            item {
                WGEmailBox(hintText = "Mail adresi")
                WGSpacer()
            }
            item {
                WGButton(
                    text = "Devam Et",
                    onClick = { onConfirmClick() },
                )
                WGSpacer()
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    MailConfirm(
        onBackClick = { /*TODO*/ },
        onConfirmClick = {}
    )
}