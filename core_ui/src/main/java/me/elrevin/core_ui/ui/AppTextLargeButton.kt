package me.elrevin.core_ui.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun AppTextLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    iconPainter: Painter? = null,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    onClick: () -> Unit
) {
    BaseTextButton(
        modifier = modifier,
        text = text,
        enabled = enabled,
        iconPainter = iconPainter,
        contentPadding = contentPadding,
        textStyle = AppTheme.typography.bodyBold,
        onClick = onClick
    )
}