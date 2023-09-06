package me.elrevin.core_ui.theme

import androidx.compose.ui.graphics.Color

fun darkAppColorScheme() = AppColorScheme(
    buttonPrimaryBg = Red50,
    buttonPrimaryText = White,
    buttonSecondaryBg = Neutral60,
    buttonSecondaryStroke = Red0,
    buttonSecondaryText = Red0,
    buttonTextText = Red50,

    buttonPrimaryPressedBg = Red80,
    buttonPrimaryPressedText = White,
    buttonSecondaryPressedBg = Neutral80,
    buttonSecondaryPressedStroke = Red0,
    buttonSecondaryPressedText = Red0,
    buttonTextPressedText = Red80,

    // Fields
    fieldDefaultBg = Neutral100,
    fieldDefaultStroke = Neutral20,
    fieldDefaultPlaceholder = Neutral60,
    fieldDefaultText = Neutral30,
    fieldDefaultIcon = Neutral60,

    fieldFocusedBg = Neutral100,
    fieldFocusedStroke = Red50,
    fieldFocusedPlaceholder = Neutral60,
    fieldFocusedText = Neutral30,
    fieldFocusedIcon = Neutral60,

    fieldDisabledBg = Neutral90,
    fieldDisabledStroke = Neutral80,
    fieldDisabledPlaceholder = Neutral80,
    fieldDisabledText = Neutral80,
    fieldDisabledIcon = Neutral80,

    background = Neutral90,
    surface = Neutral90,
    onBackground = Neutral10,
    onSurface = Neutral10,
    error = Error100,
    onError = Error10,
)