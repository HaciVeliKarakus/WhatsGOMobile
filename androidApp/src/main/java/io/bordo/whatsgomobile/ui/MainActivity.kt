package io.bordo.whatsgomobile.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import io.bordo.whatsgomobile.navigation.RootNavigationGraph
import io.bordo.whatsgomobile.ui.theme.WhatsGOMobileTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WhatsGOMobileTheme {
                RootNavigationGraph()
            }
        }
    }
}



