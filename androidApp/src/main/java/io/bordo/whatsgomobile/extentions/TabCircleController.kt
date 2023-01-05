package io.bordo.whatsgomobile.extentions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import io.bordo.whatsgomobile.ui.theme.primaryColor

@OptIn(ExperimentalPagerApi::class)
fun Modifier.tabCircleController(
    pagerState: PagerState,
    index: Int, borderSize: Dp
): Modifier = if (pagerState.currentPage == index)
    clip(shape = CircleShape)
    .size(borderSize)
    .border(1.dp, color = primaryColor, shape = CircleShape)
    .background(Color.Transparent)
else
    clip(shape = CircleShape)
    .size(borderSize)
    .background(Color.LightGray)