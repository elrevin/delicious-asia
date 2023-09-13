package me.elrevin.recipes_presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.R
import me.elrevin.core_ui.R as CoreUiRes
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.ui.AppTextSmallButton
import me.elrevin.core_ui.ui.TabLazyRow
import me.elrevin.core_ui.ui.TextH4
import me.elrevin.core_ui.ui.TextH5
import me.elrevin.recipes_domain.entity.Category

@Composable
internal fun HomeScreen(
    state: HomeScreenState,
    onActiveCategoryChange: (Int) -> Unit,
    onViewAllCategories: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
            .fillMaxSize()
        ) {
            Spacer(
                Modifier.windowInsetsBottomHeight(
                    WindowInsets.systemBars
                )
            )

            TextH4(
                text = stringResource(id = CoreUiRes.string.find_best_recipes_header),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 20.dp)
            )

            TrendingRecipesList(
                trends = state.trends,
                loadingTrends = state.showLoadingTrendsProgress
            )

            PopularCategories(
                categories = state.popularCategories,
                recipes = state.recipesOfCategory,
                activeCategory = state.activeCategory ?: 0,
                onCategoryChange = onActiveCategoryChange,
                onViewAll = onViewAllCategories
            )
        }
    }
}