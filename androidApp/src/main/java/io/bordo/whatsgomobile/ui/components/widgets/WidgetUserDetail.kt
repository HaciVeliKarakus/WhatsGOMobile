package io.bordo.whatsgomobile.ui.components.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.placeholder.placeholder
import io.bordo.whatsgomobile.ui.theme.lowfidelitygray

@Composable
fun WidgetUserDetail(
    userProfileUrl: String,
    userName: String,
    userDate: String,
    isOnline: Boolean,
    isDataLoading: Boolean
) {
    Box {
        AsyncImage(
            model = userProfileUrl,
            contentDescription = userName,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(40.dp)
                .placeholder(
                    visible = isDataLoading,
                    color = lowfidelitygray
                )
        )
        Box(
            modifier = Modifier
                .width(10.dp)
                .aspectRatio(ratio = 1f)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
                .align(Alignment.BottomEnd),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(1.dp)
                    .width(5.dp)
                    .aspectRatio(ratio = 1f)
                    .background(
                        color = if (isOnline) Color.Green else Color.Red,
                        shape = CircleShape
                    ),
            )
        }
    }
    Column(
        modifier = Modifier.padding(start = 4.dp)
    ) {
        Text(
            modifier = Modifier
                .placeholder(
                    visible = isDataLoading,
                    color = lowfidelitygray
                ),
            text = userName,
            fontSize = 12.sp
        )
        Text(
            modifier = Modifier
                .placeholder(
                    visible = isDataLoading,
                    color = lowfidelitygray
                ),
            text = userDate,
            fontSize = 10.sp,
            color = Color.LightGray
        )
    }
}
