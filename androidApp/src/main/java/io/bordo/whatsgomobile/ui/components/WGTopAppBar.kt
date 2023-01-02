package io.bordo.whatsgomobile.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WGTopAppBar(
    topSpacer: Dp = 24.dp,
    iconHorizontalPadding: Dp = 24.dp,
    backgroundColor: Color = MaterialTheme.colors.background,
    headerText: String? = null,
    elevation: Dp = 0.dp,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            headerText?.let { Text(text = it) }
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = backgroundColor,
        elevation = elevation
    )
//    Spacer(modifier = Modifier.height(topSpacer))
//
//    Row(modifier = Modifier.height(topSpacer)) {
//        Icon(
//            imageVector = Icons.Default.ArrowBack,
//            contentDescription = "Arrow Back",
//            modifier = Modifier
//                .clickable { onBackClick() }
//                .padding(horizontal = iconHorizontalPadding),
//        )
//        Spacer(modifier = Modifier.weight(1f))
//    }
}


@Preview
@Composable
private fun Preview(){
    WGTopAppBar() {
        
    }
}