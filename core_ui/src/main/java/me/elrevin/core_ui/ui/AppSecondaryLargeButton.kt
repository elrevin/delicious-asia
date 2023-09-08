package me.elrevin.core_ui.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun AppSecondaryLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    iconPainter: Painter? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BaseSecondaryButton(
        modifier = modifier,
        text = text,
        iconPainter = iconPainter,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        textStyle = AppTheme.typography.bodyBold,
        enabled = enabled,
        onClick = onClick
    )
}