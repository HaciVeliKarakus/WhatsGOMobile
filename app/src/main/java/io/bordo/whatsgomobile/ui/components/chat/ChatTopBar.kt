package io.bordo.whatsgomobile.ui.components.chat

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import io.bordo.common.domain.model.Player

@Composable
fun ChatTopBar(user: Player, onBack: (() -> Unit?)? = null) {
    TopAppBar(
        elevation = 4.dp,
        backgroundColor = Color(0xFFFFFFFF),
//        contentColor = Color.White
    )
    {

        Row(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .clip(RoundedCornerShape(percent = 50))
                    .clickable {
                        onBack?.invoke()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )

                Surface(
                    modifier = Modifier.padding(6.dp),
                    shape = CircleShape,
//                    color = Color.LightGray
                ) {
//                    Icon(
//                        imageVector = Icons.Filled.Groups,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .background(Color.LightGray)
//                            .padding(4.dp)
//                            .fillMaxHeight()
//                            .aspectRatio(1f)
//                    )
                    AsyncImage(model = user.photoUrl, contentDescription = user.name)
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { }
                    .padding(2.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = user.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        "This is dynamic chat sample",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        ChatAppbarActions()
    }
}


@Composable
private fun ChatAppbarActions(
    onCamClick: (() -> Unit)? = null,
    onCallClick: (() -> Unit)? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
//        IndicatingIconButton(
//            onClick = { /* doSomething() */ },
//            indication = rememberRipple(bounded = false, radius = 22.dp),
//            modifier = Modifier.then(Modifier.size(44.dp))
//        ) {
//            Icon(
//                imageVector = Icons.Rounded.Videocam,
//                contentDescription = null,
//                tint = Color.White
//            )
//        }

        IndicatingIconButton(
            onClick = { /* doSomething() */ },
            indication = rememberRipple(bounded = false, radius = 22.dp),
            modifier = Modifier.then(Modifier.size(44.dp))
        ) {
            Icon(
                imageVector = Icons.Rounded.PowerSettingsNew,
                contentDescription = null,
            )
        }

        IndicatingIconButton(
            onClick = { /* doSomething() */ },
            indication = rememberRipple(bounded = false, radius = 22.dp),
            modifier = Modifier.then(Modifier.size(44.dp))
        ) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = null,
            )
        }
    }
}

// Default radius of an unbounded ripple in an IconButton
private val RippleRadius = 24.dp

/**
 * Icon Button with adjustable indication option. Indication of standard [IconButton] cannot
 * be changed thus making it have bigger radius than necessary in some cases.
 */
@Composable
fun IndicatingIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication = rememberRipple(bounded = false, radius = RippleRadius),
    content: @Composable () -> Unit
) {

    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = indication
            ),
        contentAlignment = Alignment.Center
    ) {
        val contentAlpha = if (enabled) LocalContentAlpha.current else ContentAlpha.disabled
        CompositionLocalProvider(LocalContentAlpha provides contentAlpha, content = content)
    }
}