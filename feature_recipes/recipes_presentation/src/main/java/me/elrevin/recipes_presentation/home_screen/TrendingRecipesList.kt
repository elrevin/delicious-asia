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
import me.elrevin.core_ui.ui.TextH5
import me.elrevin.recipes_domain.entity.Recipe
import me.elrevin.recipes_presentation.common_ui.LargeRecipeCard

@Composable
fun TrendingRecipesList(
    trends: List<Recipe?>
) {
    Column (
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
            TextH5(text = stringResource(id = R.string.trending_now))
            AppTextSmallButton(text = stringResource(
                id = R.string.all_recipes),
                iconPainter = AppTheme.icons.arrowRight,
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 0.dp),
                onClick = {}
            )
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(trends.size) {
                LargeRecipeCard(recipe = trends[it], onAddToFavorites = {})
            }
        }
    }
}