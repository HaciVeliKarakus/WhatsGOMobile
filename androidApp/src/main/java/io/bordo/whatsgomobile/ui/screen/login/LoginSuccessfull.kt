package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.atoms.AtomButton
import io.bordo.whatsgomobile.ui.components.atoms.AtomImage
import io.bordo.whatsgomobile.ui.components.atoms.AtomSpacer
import io.bordo.whatsgomobile.ui.components.atoms.AtomText
import io.bordo.whatsgomobile.ui.theme.BlackMain
import io.bordo.whatsgomobile.ui.theme.PurpleMain


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
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(durationMillis = 500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 500))
        ) {
            AtomImage(id = R.drawable.successful)
        }
        AtomText(
            text = "Şifren Başarıyla Değiştirildi",
            fontSize = 24.sp,
            color = PurpleMain,
            fontWeight = FontWeight.Bold
        )
        AtomSpacer()
        AtomText(
            text = "Hesabınıza yeni oluşturduğunuz şifrenizi kullanarak yeniden giriş yapmayı deneyebilirsiniz.",
            fontSize = 16.sp,
            color = BlackMain,
            horizontalPadding = 24.dp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        AtomButton(
            text = "WhatsGo'ya Giriş",
            iconId = R.drawable.ic_logo,
            onClick = { onClickSuccess() },
        )
        AtomSpacer()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    Successful(onClickSuccess = {})
}