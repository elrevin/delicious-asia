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
    val buttonText: Color,

    val buttonPrimaryPressedBg: Color,
    val buttonPrimaryPressedText: Color,
    val buttonSecondaryPressedBg: Color,
    val buttonSecondaryPressedStroke: Color,
    val buttonSecondaryPressedText: Color,
    val buttonPressedText: Color,

    val buttonPrimaryDisabledBg: Color,
    val buttonPrimaryDisabledText: Color,
    val buttonSecondaryDisabledBg: Color,
    val buttonSecondaryDisabledStroke: Color,
    val buttonSecondaryDisabledText: Color,
    val buttonDisabledText: Color,

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

    val fieldDisabledBg: Color,
    val fieldDisabledStroke: Color,
    val fieldDisabledPlaceholder: Color,
    val fieldDisabledText: Color,
    val fieldDisabledIcon: Color,

    // Other
    val background: Color,
    val surface: Color,
    val onBackground: Color,
    val onBackgroundSecond: Color,
    val onSurface: Color,
    val error: Color,
    val onError: Color,
    val smallRecipeBackground: Color,
    val onSmallRecipeBackground: Color,
    val onSmallRecipeBackgroundSecond: Color,
    val tabDefaultBackground: Color,
    val tabActiveBackground: Color,
    val tabDefaultText: Color,
    val tabActiveText: Color,

)

val localAppColors = staticCompositionLocalOf {
    AppColorScheme(
        // Buttons
        buttonPrimaryBg = Color.Unspecified,
        buttonPrimaryText = Color.Unspecified,
        buttonSecondaryBg = Color.Unspecified,
        buttonSecondaryStroke = Color.Unspecified,
        buttonSecondaryText = Color.Unspecified,
        buttonText = Color.Unspecified,

        buttonPrimaryPressedBg = Color.Unspecified,
        buttonPrimaryPressedText = Color.Unspecified,
        buttonSecondaryPressedBg = Color.Unspecified,
        buttonSecondaryPressedStroke = Color.Unspecified,
        buttonSecondaryPressedText = Color.Unspecified,
        buttonPressedText = Color.Unspecified,

        buttonPrimaryDisabledBg = Color.Unspecified,
        buttonPrimaryDisabledText = Color.Unspecified,
        buttonSecondaryDisabledBg = Color.Unspecified,
        buttonSecondaryDisabledStroke = Color.Unspecified,
        buttonSecondaryDisabledText = Color.Unspecified,
        buttonDisabledText = Color.Unspecified,

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

        fieldDisabledBg = Color.Unspecified,
        fieldDisabledStroke = Color.Unspecified,
        fieldDisabledPlaceholder = Color.Unspecified,
        fieldDisabledText = Color.Unspecified,
        fieldDisabledIcon = Color.Unspecified,

        background = Color.Unspecified,
        surface = Color.Unspecified,
        onBackground = Color.Unspecified,
        onBackgroundSecond = Color.Unspecified,
        onSurface = Color.Unspecified,
        error = Color.Unspecified,
        onError = Color.Unspecified,
        smallRecipeBackground = Color.Unspecified,
        onSmallRecipeBackground = Color.Unspecified,
        onSmallRecipeBackgroundSecond = Color.Unspecified,
        tabDefaultBackground = Color.Unspecified,
        tabActiveBackground = Color.Unspecified,
        tabDefaultText = Color.Unspecified,
        tabActiveText = Color.Unspecified,
    )
}