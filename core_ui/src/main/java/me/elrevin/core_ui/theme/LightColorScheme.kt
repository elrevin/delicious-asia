package me.elrevin.core_ui.theme

import androidx.compose.ui.graphics.Color

fun lightAppColorScheme() = AppColorScheme(
    buttonPrimaryBg = Red50,
    buttonPrimaryText = White,
    buttonSecondaryBg = Color.Transparent,
    buttonSecondaryStroke = Red50,
    buttonSecondaryText = Red50,
    buttonText = Red50,

    buttonPrimaryPressedBg = Red80,
    buttonPrimaryPressedText = White,
    buttonSecondaryPressedBg = Neutral10,
    buttonSecondaryPressedStroke = Red80,
    buttonSecondaryPressedText = Red80,
    buttonPressedText = Red80,

    buttonPrimaryDisabledBg = Neutral20,
    buttonPrimaryDisabledText = Neutral50,
    buttonSecondaryDisabledBg = Color.Transparent,
    buttonSecondaryDisabledStroke = Neutral20,
    buttonSecondaryDisabledText = Neutral50,
    buttonDisabledText = Neutral50,

    // Fields
    fieldDefaultBg = White,
    fieldDefaultStroke = Neutral20,
    fieldDefaultPlaceholder = Neutral20,
    fieldDefaultText = Neutral90,
    fieldDefaultIcon = Neutral20,

    fieldFocusedBg = White,
    fieldFocusedStroke = Red50,
    fieldFocusedPlaceholder = Neutral20,
    fieldFocusedText = Neutral90,
    fieldFocusedIcon = Neutral20,

    fieldDisabledBg = Neutral10,
    fieldDisabledStroke = Neutral30,
    fieldDisabledPlaceholder = Neutral30,
    fieldDisabledText = Neutral30,
    fieldDisabledIcon = Neutral30,

    background = White,
    surface = White,
    onBackground = Neutral90,
    onBackgroundSecond = Neutral40,
    onSurface = Neutral90,
    error = Error100,
    onError = Error10,
    smallRecipeBackground = Neutral10,
    onSmallRecipeBackground = Neutral90,
    onSmallRecipeBackgroundSecond = Neutral30,
    tabDefaultBackground = White,
    tabActiveBackground = Red50,
    tabDefaultText = Red30,
    tabActiveText = White,
)