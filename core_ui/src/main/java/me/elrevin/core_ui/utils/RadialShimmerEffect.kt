package me.elrevin.core_ui.utils

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import kotlin.math.sqrt

fun Modifier.radialShimmerEffect(
    color1: Color,
    color2: Color
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    var radius by remember {
        mutableFloatStateOf(1f)
    }

    val transition = rememberInfiniteTransition("shimmer")
    val offset by transition.animateFloat(
        initialValue = -1f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(1500)
        ), label = ""
    )

    background(
        brush = Brush.radialGradient(
            offset to color1,
            offset + 0.3f to color2,
            offset + 0.6f to color1,
            center = Offset(size.width.toFloat() / 2f, size.height.toFloat() / 2f),
            radius = radius,
            tileMode = TileMode.Repeated
        )
    ).onGloballyPositioned {
        size = it.size
        val max = maxOf(it.size.width, it.size.height)
        radius = sqrt( max * max * 2f) / 2
    }
}