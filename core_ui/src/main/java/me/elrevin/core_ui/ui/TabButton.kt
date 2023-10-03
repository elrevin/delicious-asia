package me.elrevin.core_ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun TabButton(
    modifier: Modifier = Modifier,
    text: String,
    active: Boolean,
    tag: Any,
    onClick: (tag: Any) -> Unit
) {
    val background =
        if (active) AppTheme.colors.tabActiveBackground else AppTheme.colors.tabDefaultBackground
    val textColor = if (active) AppTheme.colors.tabActiveText else AppTheme.colors.tabDefaultText
    Box(
        modifier = modifier
            .then(
                Modifier
                    .height(34.dp)
                    .clip(AppTheme.shapes.medium)
                    .background(background)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .clickable { onClick(tag) }
            ),
        contentAlignment = Alignment.Center
    ) {
        TextSmallBold(text = text, color = textColor)
    }
}