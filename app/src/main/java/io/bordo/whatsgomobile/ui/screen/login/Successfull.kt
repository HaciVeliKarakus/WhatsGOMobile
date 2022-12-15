package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.WGButton
import io.bordo.whatsgomobile.ui.theme.primaryColor


@Composable
fun Successful(
    onClickSuccess: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val visible by remember { mutableStateOf(true) }
        val mContext = LocalContext.current
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 500))
        ) {
            Image(painterResource(id = R.drawable.successful), contentDescription = "success-logo")
        }
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Şifren Başarıyla Değiştirildi",
            textAlign = TextAlign.Center,
            color = primaryColor,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Hesabınıza yeni oluşturduğunuz şifrenizi kullanarak yeniden giriş yapmayı deneyebilirsiniz.",
//            fontWeight = FontWeight.Thin,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        WGButton(
            text = "WhatsGo'ya Giriş",
            iconId = R.drawable.ic_logo,
            onClick = { onClickSuccess() }
        )
    }
}
