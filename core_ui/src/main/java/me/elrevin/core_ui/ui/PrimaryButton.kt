package me.elrevin.core_ui.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun AppPrimaryTextIconButton(
    text: String,
    iconPainter: Painter,
    onClick: () -> Unit
) {
    BasePrimaryButton(
        text = text,
        iconPainter = iconPainter,
        onClick = onClick
    )
}