package me.elrevin.core_ui.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun BaseSecondaryButton(
    modifier: Modifier,
    text: String? = null,
    iconPainter: Painter? = null,
    contentPadding: PaddingValues,
    textStyle: TextStyle,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val borderColor = if (enabled) {
        AppTheme.colors.buttonSecondaryStroke
    } else {
        AppTheme.colors.buttonSecondaryDisabledStroke
    }

    Button(
        modifier = modifier,
        border = BorderStroke(1.dp, borderColor),
        onClick = onClick,
        shape = AppTheme.shapes.medium,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.buttonSecondaryBg,
            contentColor = AppTheme.colors.buttonSecondaryText,
            disabledContainerColor = AppTheme.colors.buttonSecondaryDisabledBg,
            disabledContentColor = AppTheme.colors.buttonSecondaryDisabledText
        ),
        contentPadding = contentPadding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (text != null) {
                Text(
                    text = text,
                    style = textStyle
                )
                if (iconPainter != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            if (iconPainter != null) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = iconPainter,
                    contentDescription = ""
                )
            }
        }
    }
}