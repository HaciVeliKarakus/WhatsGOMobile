package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.WGButton
import io.bordo.whatsgomobile.ui.theme.whatsappGreen


@Composable
fun LoginPage(
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit
) {
    val mContext = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            LogoSection()
            Spacer(modifier = Modifier.height(32.dp))
            WGButton(
                text = "Whatsapp ile Giriş",
                iconId = R.drawable.ic_whatsapp_24,
                backColor = whatsappGreen
            ) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            WGButton(
                text = "Google ile Giriş",
                R.drawable.ic_google,
                textColor = Color.Black,
                backColor = Color.White
            ) {

            }

            DividerSection()

            EmailSection()
            PasswordSection()
            Spacer(modifier = Modifier.height(16.dp))
            WGButton(
                text = "Giriş Yap"
            ) {
                onLoginClick()
            }
            Spacer(modifier = Modifier.height(22.dp))
            TextButton(
                onClick = { onForgetClick() },
            ) {
                Text(text = "Şifremi Unuttum")
            }
        }
    }
}


@Composable
private fun LogoSection() {
    Image(
        painterResource(id = R.drawable.logo_name_main),
        contentDescription = null
    )
}


@Composable
private fun DividerSection() {
    Spacer(modifier = Modifier.height(26.dp))
    Box(contentAlignment = Alignment.Center) {
        Divider(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .width(300.dp),
            color = Color.LightGray
        )
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            Text(
                text = "VEYA",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(26.dp))
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
                text = "Mail adresiniz",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = textFieldState.value.text
                textFieldState.value =
                    textFieldState.value.copy(selection = TextRange(0, text.length))
            }
        })
}

@Composable
private fun PasswordSection() {
    val password = remember { mutableStateOf(TextFieldValue("")) }

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(value = password.value,
        onValueChange = { password.value = it },
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = {
            Text(
                text = "Şifreniz",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = password.value.text
                password.value = password.value.copy(selection = TextRange(0, text.length))
            }
        })
}
