package me.elrevin.core_ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppColorScheme(
    // Buttons
    val buttonPrimaryBg: Color,
    val buttonPrimaryText: Color,
    val buttonSecondaryBg: Color,
    val buttonSecondaryStroke: Color,
    val buttonSecondaryText: Color,
    val buttonTextText: Color,

    val buttonPrimaryPressedBg: Color,
    val buttonPrimaryPressedText: Color,
    val buttonSecondaryPressedBg: Color,
    val buttonSecondaryPressedStroke: Color,
    val buttonSecondaryPressedText: Color,
    val buttonTextPressedText: Color,

    // Fields
    val fieldDefaultBg: Color,
    val fieldDefaultStroke: Color,
    val fieldDefaultPlaceholder: Color,
    val fieldDefaultText: Color,
    val fieldDefaultIcon: Color,

    val fieldFocusedBg: Color,
    val fieldFocusedStroke: Color,
    val fieldFocusedPlaceholder: Color,
    val fieldFocusedText: Color,
    val fieldFocusedIcon: Color,

    val background: Color,
    val surface: Color,
    val onBackground: Color,
    val onSurface: Color,
    val error: Color,
    val onError: Color,
)

val localAppColors = staticCompositionLocalOf {
    AppColorScheme(
        // Buttons
        buttonPrimaryBg = Color.Unspecified,
        buttonPrimaryText = Color.Unspecified,
        buttonSecondaryBg = Color.Unspecified,
        buttonSecondaryStroke = Color.Unspecified,
        buttonSecondaryText = Color.Unspecified,
        buttonTextText = Color.Unspecified,

        buttonPrimaryPressedBg = Color.Unspecified,
        buttonPrimaryPressedText = Color.Unspecified,
        buttonSecondaryPressedBg = Color.Unspecified,
        buttonSecondaryPressedStroke = Color.Unspecified,
        buttonSecondaryPressedText = Color.Unspecified,
        buttonTextPressedText = Color.Unspecified,

        // Fields
        fieldDefaultBg = Color.Unspecified,
        fieldDefaultStroke = Color.Unspecified,
        fieldDefaultPlaceholder = Color.Unspecified,
        fieldDefaultText = Color.Unspecified,
        fieldDefaultIcon = Color.Unspecified,

        fieldFocusedBg = Color.Unspecified,
        fieldFocusedStroke = Color.Unspecified,
        fieldFocusedPlaceholder = Color.Unspecified,
        fieldFocusedText = Color.Unspecified,
        fieldFocusedIcon = Color.Unspecified,

        background = Color.Unspecified,
        surface = Color.Unspecified,
        onBackground = Color.Unspecified,
        onSurface = Color.Unspecified,
        error = Color.Unspecified,
        onError = Color.Unspecified,
    )
}