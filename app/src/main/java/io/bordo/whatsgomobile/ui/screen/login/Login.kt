package io.bordo.whatsgomobile.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.bordo.whatsgomobile.R
import io.bordo.whatsgomobile.ui.components.atoms.AtomButton
import io.bordo.whatsgomobile.ui.components.atoms.AtomDivider
import io.bordo.whatsgomobile.ui.components.atoms.AtomImage
import io.bordo.whatsgomobile.ui.components.atoms.AtomSpacer
import io.bordo.whatsgomobile.ui.components.molecules.MoleculeEmailBox
import io.bordo.whatsgomobile.ui.components.widgets.MoleculePasswordBox
import io.bordo.whatsgomobile.ui.theme.whatsappGreen


@Composable
fun LoginPage(
    onLoginClick: () -> Unit,
    onForgetClick: () -> Unit
) {
    Scaffold {
        LazyColumn(
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                AtomImage(id = R.drawable.logo_name_main)
                AtomSpacer(height = 32.dp,)
            }
            item {
                AtomButton(
                    text = "Whatsapp ile Giriş",
                    iconId = R.drawable.ic_whatsapp_24,
                    backColor = whatsappGreen,
                    onClick = {}
                )
                AtomSpacer(height = 16.dp,)
                AtomButton(
                    text = "Google ile Giriş",
                    iconId = R.drawable.ic_google,
                    textColor = Color.Black,
                    backColor = Color.White,
                    onClick = {}
                )
            }
            item {
                AtomSpacer(height = 26.dp,)
                AtomDivider(centerText = "VEYA")
                AtomSpacer(height = 26.dp,)
            }
            item {
                MoleculeEmailBox()
                MoleculePasswordBox(hintText = "Şifreniz")
                AtomSpacer(height = 32.dp,)
            }
            item {
                AtomButton(
                    text = "Giriş Yap",
                    onClick = { onLoginClick() }
                )
                TextButton(
                    onClick = { onForgetClick() },
                ) {
                    Text(text = "Şifremi Unuttum")
                }
                AtomSpacer()
            }
        }
    }
}





