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
import io.bordo.whatsgomobile.ui.components.atoms.AtomButton
import io.bordo.whatsgomobile.ui.components.atoms.AtomSpacer
import io.bordo.whatsgomobile.ui.components.atoms.AtomText
import io.bordo.whatsgomobile.ui.components.widgets.BackSection
import io.bordo.whatsgomobile.ui.components.widgets.WidgetEmailBox
import io.bordo.whatsgomobile.ui.theme.GrayMain


@Composable
fun MailConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Scaffold(
        topBar = { BackSection(onBackClick = onBackClick) }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    AtomText(
                        text = "Şifremi Unuttum",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    AtomSpacer()
                    AtomText(
                        text = "E-posta adresinizi aşağıya yazın, size şifrenizi sıfırlamanız için bir bağlantı göndereceğiz.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = GrayMain,
                    )
                    AtomSpacer(height = 24.dp)
                }
            }
            item {
                WidgetEmailBox(hintText = "Mail adresi")
                AtomSpacer()
            }
            item {
                AtomButton(
                    text = "Devam Et",
                    onClick = { onConfirmClick() },
                )
                AtomSpacer()
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