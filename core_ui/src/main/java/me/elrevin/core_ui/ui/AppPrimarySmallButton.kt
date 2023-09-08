package me.elrevin.core_ui.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun AppPrimarySmallButton(
    modifier: Modifier = Modifier,
    text: String,
    iconPainter: Painter? = null,
    onClick: () -> Unit
) {
    BasePrimaryButton(
        modifier = modifier,
        text = text,
        iconPainter = iconPainter,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        textStyle = AppTheme.typography.labelBold,
        onClick = onClick
    )
}