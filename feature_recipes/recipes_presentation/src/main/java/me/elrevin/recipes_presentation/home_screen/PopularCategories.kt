package me.elrevin.recipes_presentation.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.ui.AppTextSmallButton
import me.elrevin.core_ui.ui.TabLazyRow
import me.elrevin.core_ui.ui.TextH5
import me.elrevin.recipes_domain.entity.Category
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_presentation.common_ui.SmallRecipeCard

@Composable
internal fun PopularCategories(
    categories: List<Category?>,
    activeCategory: Int,
    recipes: List<Recipe?>,
    onCategoryChange: (Int) -> Unit,
    onViewAll: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextH5(text = stringResource(id = R.string.popular_category))
            AppTextSmallButton(
                text = stringResource(
                    id = R.string.view_all
                ),
                iconPainter = AppTheme.icons.arrowRight,
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 0.dp),
                onClick = onViewAll
            )
        }

        TabLazyRow(
            modifier = Modifier.padding(bottom = 20.dp),
            list = categories.map { if (it != null) Pair(it.id, it.name) else null },
            activeTag = activeCategory,
            onTabClick = { onCategoryChange(it as Int) }
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recipes.size) {
                SmallRecipeCard(recipe = recipes[it], onAddToFavorites = {})
            }
        }
    }
}