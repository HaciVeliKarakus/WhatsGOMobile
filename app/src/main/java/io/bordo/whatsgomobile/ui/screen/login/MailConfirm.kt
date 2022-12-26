package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.BackSection
import io.bordo.whatsgomobile.ui.components.WGButton


@Composable
fun MailConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Scaffold(
        topBar = { BackSection(onBackClick=onBackClick) },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                InformationSection(bottomSpacer = 16.dp)
            }
            item {
                EmailSection()
            }
            item {
                WGButton(
                    text = "Devam Et",
                    onClick = { onConfirmClick() },
                    bottomSpacer = 16.dp
                )
            }
        }
    }

//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//
//    }
}

@Composable
fun InformationSection(
    topSpacer: Dp = 16.dp,
    centerSpacer: Dp = 16.dp,
    bottomSpacer: Dp = 16.dp
) {
    Spacer(modifier = Modifier.height(topSpacer))
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "Şifremi Unuttum",
            fontSize = 24.sp,
        )
        Spacer(modifier = Modifier.height(centerSpacer))
        Text(
            text = "E-posta adresinizi aşağıya yazın, size şifrenizi sıfırlamanız için bir bağlantı göndereceğiz.",
            fontSize = 12.sp,
            color = Color.LightGray,
            lineHeight = 20.sp
        )
        Spacer(modifier = Modifier.height(bottomSpacer))

    }
}


@Composable
private fun EmailSection(bottomSpacer: Dp = 16.dp) {
    val textFieldState = remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(value = textFieldState.value,
        onValueChange = { textFieldState.value = it },
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = {
            Text(
                text = "Mail adresi",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = textFieldState.value.text
                textFieldState.value = textFieldState.value.copy(
                    selection = TextRange(0, text.length)
                )
            }
        })

    Spacer(modifier = Modifier.height(bottomSpacer))
}
