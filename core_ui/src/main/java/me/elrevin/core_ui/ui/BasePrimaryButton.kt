package me.elrevin.core_ui.ui

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
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun BasePrimaryButton(
    text: String? = null,
    iconPainter: Painter? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = AppTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.buttonPrimaryBg,
            contentColor = AppTheme.colors.buttonPrimaryText
        ),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (text != null) {
                Text(
                    text = text,
                    style = AppTheme.typography.bodyBold
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