package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.atoms.AtomButton
import io.bordo.whatsgomobile.ui.components.atoms.AtomSpacer
import io.bordo.whatsgomobile.ui.components.atoms.AtomText
import io.bordo.whatsgomobile.ui.components.widgets.BackSection
import io.bordo.whatsgomobile.ui.components.widgets.WidgetPasswordBox
import io.bordo.whatsgomobile.ui.theme.GrayMain

@Composable
fun PasswordConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Scaffold(topBar = { BackSection(onBackClick = onBackClick) }) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {
                    AtomText(
                        text = "Yeni Şifre Belirle",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    AtomSpacer(8.dp)
                    AtomText(
                        text = "WhatsGO hesabınız için yeni bir şifre belirleyin.",
                        color = GrayMain
                    )
                    AtomSpacer(24.dp)
                }
            }
            item {
                WidgetPasswordBox(hintText = "Şifre")
                AtomSpacer()
                WidgetPasswordBox(hintText = "Şifre tekrar")
                AtomSpacer()
            }
            item {
                AtomButton(
                    text = "Devam Et",
                    onClick = onConfirmClick
                )
                AtomSpacer()
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