package me.elrevin.core_ui.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    prefixIconPainter: Painter? = null,
    suffixIconPainter: Painter? = null,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    onValueChange: (String) -> Unit = {}
) {
    val textColor = when {
        !enabled -> AppTheme.colors.fieldDisabledText
        else -> AppTheme.colors.fieldDefaultText
    }
    val interactionSource = remember { MutableInteractionSource() }
    val focused by interactionSource.collectIsFocusedAsState()
    CompositionLocalProvider(LocalTextSelectionColors provides LocalTextSelectionColors.current) {
        BasicTextField(
            value = value,
            modifier = modifier,
            onValueChange = onValueChange,
            enabled = enabled,
            textStyle = AppTheme.typography.label.copy(color = textColor),
            cursorBrush = SolidColor(AppTheme.colors.fieldFocusedText),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            decorationBox = @Composable { innerTextField ->
                DecorationBox(
                    enabled = enabled,
                    focused = focused,
                    prefixIconPainter = prefixIconPainter,
                    suffixIconPainter = suffixIconPainter,
                    label = label,
                    value = value,
                    innerTextField
                )
            }
        )
    }
}

@Composable
private fun DecorationBox(
    enabled: Boolean,
    focused: Boolean,
    prefixIconPainter: Painter?,
    suffixIconPainter: Painter?,
    label: String,
    value: String,
    innerTextField: @Composable () -> Unit
) {
    val borderColor = when {
        !enabled -> AppTheme.colors.fieldDisabledStroke
        focused -> AppTheme.colors.fieldFocusedStroke
        else -> AppTheme.colors.fieldDefaultStroke
    }

    val backgroundColor = when {
        !enabled -> AppTheme.colors.fieldDisabledBg
        focused -> AppTheme.colors.fieldFocusedBg
        else -> AppTheme.colors.fieldDefaultBg
    }

    val placeHolderColor = when {
        !enabled -> AppTheme.colors.fieldDisabledPlaceholder
        focused -> AppTheme.colors.fieldFocusedPlaceholder
        else -> AppTheme.colors.fieldDefaultPlaceholder
    }

    val iconsColor = when {
        !enabled -> AppTheme.colors.fieldDisabledIcon
        focused -> AppTheme.colors.fieldFocusedIcon
        else -> AppTheme.colors.fieldDefaultIcon
    }
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = AppTheme.shapes.medium
            )
            .background(color = backgroundColor, shape = AppTheme.shapes.medium)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        if (prefixIconPainter != null) {
            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = prefixIconPainter,
                contentDescription = "",
                tint = iconsColor
            )
            Spacer(modifier = Modifier.width(12.dp))
        }

        Box (modifier = Modifier.weight(1f)){
            if (value.isEmpty()) {
                Text(
                    text = label,
                    style = AppTheme.typography.label,
                    color = placeHolderColor
                )
            }
            innerTextField()
        }

        if (suffixIconPainter != null) {
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = prefixIconPainter!!,
                contentDescription = "",
                tint = iconsColor
            )
        }
    }
}