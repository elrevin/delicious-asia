package me.elrevin.view_recipes_presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme

@Composable
internal fun HomeScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .horizontalScroll(rememberScrollState())
    ) {
        Spacer(
            Modifier.windowInsetsBottomHeight(
                WindowInsets.systemBars
            )
        )

        Text(
            text = "Find the best recipes from the Central Asia",
            style = AppTheme.typography.h4Bold,
            color = AppTheme.colors.onBackground,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, vertical = 20.dp)
        )
    }

}