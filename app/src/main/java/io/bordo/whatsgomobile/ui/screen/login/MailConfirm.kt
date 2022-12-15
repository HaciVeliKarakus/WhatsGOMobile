package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.WGButton


@Composable
fun MailConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        BackSection(onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            InformationSection()
            Spacer(modifier = Modifier.height(16.dp))
            EmailSection()
            Spacer(modifier = Modifier.height(16.dp))
            WGButton(
                text = "Devam Et",
                onClick = { onConfirmClick() }
            )
        }
    }
}

@Composable
fun InformationSection() {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "Şifremi Unuttum",
            fontSize = 24.sp,
//            fontWeight = FontWeight.Light,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "E-posta adresinizi aşağıya yazın, size şifrenizi sıfırlamanız için bir bağlantı göndereceğiz.",
            fontSize = 12.sp,
//            fontWeight = FontWeight.Thin,
            color = Color.LightGray,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun BackSection(onBackClick: () -> Unit) {
    Row {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Arrow Back",
            modifier = Modifier
                .clickable { onBackClick() }
                .padding(horizontal = 24.dp),
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun EmailSection() {
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
}