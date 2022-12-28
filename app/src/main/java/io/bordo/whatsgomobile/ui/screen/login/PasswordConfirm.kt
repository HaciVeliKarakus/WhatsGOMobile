package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.components.atoms.AtomButton
import io.bordo.whatsgomobile.ui.components.atoms.AtomSpacer
import io.bordo.whatsgomobile.ui.components.atoms.BackSection

@Composable
fun PasswordConfirm(
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        BackSection(onBackClick = { onBackClick() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            InformationSection2()
            PasswordSection()
            Spacer(modifier = Modifier.height(16.dp))
            PasswordConfirmSection()
            AtomSpacer(height = 16.dp,)
            AtomButton(
                text = "Devam Et",
                onClick = { onConfirmClick() },
            )
            AtomSpacer(height = 16.dp,)
        }
    }
}

@Composable
fun InformationSection2() {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "Yeni Şifre Belirle",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "WhatsGO hesabınız için yeni bir şifre belirleyin.",
            fontSize = 12.sp,
//            fontWeight = FontWeight.Thin,
            color = Color.LightGray,
            lineHeight = 20.sp
        )
    }
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
                text = "Şifre",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = password.value.text
                password.value = password.value.copy(
                    selection = TextRange(0, text.length)
                )
            }
        })
}

@Composable
private fun PasswordConfirmSection() {
    val password = remember { mutableStateOf(TextFieldValue("")) }

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(value = password.value,
        onValueChange = { password.value = it },
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = {
            Text(
                text = "Şifre Tekrarı",
                color = Color.LightGray,
                fontSize = 12.sp,
            )
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, description)
            }
        },
        modifier = Modifier.onFocusChanged { focusState ->
            if (focusState.isFocused) {
                val text = password.value.text
                password.value = password.value.copy(
                    selection = TextRange(0, text.length)
                )
            }
        })
}
