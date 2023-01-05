package io.bordo.whatsgomobile.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.bordo.whatsgomobile.ui.theme.*

@Composable
fun WGSurveyPanel() {
    WGCard {
        WGText(
            text = "Anket",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        WGSpacer()
        WGText(
            text = "Aut inventore cum libero labore delectus voluptas hic aspernatur." +
                    " Impedit facere explicabo eligendi deleniti sit?",
            fontSize = 15.sp
        )

        WGSpacer()

        WGSurvey(text = "Evet", value = 17, OrangeMain)
        WGSpacer()

        WGSurvey(text = "Hayır", value = 79, YellowMain)
        WGSpacer()

        WGSurvey(text = "Kararsız", value = 44, PurpleMain)
    }
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    WGSurveyPanel()
}