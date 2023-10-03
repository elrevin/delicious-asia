package me.elrevin.recipes_presentation.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.elrevin.core_ui.R as CoreUiRes
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral10
import me.elrevin.core_ui.theme.Neutral20
import me.elrevin.core_ui.theme.Neutral30
import me.elrevin.core_ui.theme.Neutral40
import me.elrevin.core_ui.theme.Neutral70
import me.elrevin.core_ui.theme.Neutral80
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.TextBodyBold
import me.elrevin.core_ui.ui.TextLabelBold
import me.elrevin.core_ui.ui.TextSmall
import me.elrevin.core_ui.utils.radialShimmerEffect
import me.elrevin.recipes_domain.entity.Recipe

/**
 * A card with recipe data, used in trends list, in search results and on explore screen. [width] can
 * be null when fillMaxWidth is needed, in other cases [width] must be a value in DP
 *
 * @param width width of the card
 * @param recipe recipe data
 */
@Composable
fun LargeRecipeCard(
    width: Dp? = 280.dp,
    recipe: Recipe?,
    onAddToFavorites: () -> Unit
) {
    val modifier: Modifier = if (width != null) {
        Modifier.width(width)
    } else {
        Modifier.fillMaxWidth()
    }

    Column(
        modifier = modifier
    ) {
        if (recipe != null) {
            RecipeCard(recipe = recipe, onAddToFavorites = onAddToFavorites)
        } else {
            LoadingCard()
        }
    }
}

@Composable
private fun LoadingCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(AppTheme.shapes.large)
            .radialShimmerEffect(AppTheme.colors.shimmerColor1, AppTheme.colors.shimmerColor2)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 8.dp)
            .radialShimmerEffect(AppTheme.colors.shimmerColor1, AppTheme.colors.shimmerColor2),
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(50))
                .radialShimmerEffect(AppTheme.colors.shimmerColor1, AppTheme.colors.shimmerColor2)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(15.dp)
                .clip(AppTheme.shapes.small)
                .radialShimmerEffect(AppTheme.colors.shimmerColor1, AppTheme.colors.shimmerColor2)
        )
    }
}

@Composable
private fun RecipeCard(
    recipe: Recipe,
    onAddToFavorites: () -> Unit
) {
    MainPhotoBlock(recipe = recipe, onAddToFavorites)
    TextBodyBold(
        text = recipe.name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 8.dp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(50)),
            model = recipe.author.avatar,
            contentScale = ContentScale.Crop,
            contentDescription = recipe.author.name,
        )
        TextSmall(text = recipe.author.name, color = AppTheme.colors.onBackgroundSecond)
    }
}

@Composable
private fun MainPhotoBlock(
    recipe: Recipe,
    onAddToFavorites: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(AppTheme.shapes.large),
            model = recipe.mainPhoto,
            contentScale = ContentScale.Crop,
            contentDescription = "Main photo of ${recipe.mainPhoto}"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier
                        .height(28.dp)
                        .clip(AppTheme.shapes.small)
                        .background(Neutral70.copy(0.7f))
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.width(20.dp),
                        painter = AppTheme.icons.star,
                        contentDescription = stringResource(id = CoreUiRes.string.rating),
                        tint = White
                    )

                    TextLabelBold(
                        modifier = Modifier.padding(top = 3.dp),
                        text = recipe.getRating(),
                        color = White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(50))
                        .background(color = White)
                        .clickable {
                            onAddToFavorites()
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.size(21.dp),
                        painter = AppTheme.icons.bookmark,
                        contentDescription = "",
                        tint = Neutral80
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .height(28.dp)
                        .clip(AppTheme.shapes.small)
                        .background(Neutral70.copy(0.7f))
                        .padding(horizontal = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    TextLabelBold(
                        text = recipe.cuisine.name + " " + stringResource(id = CoreUiRes.string.cuisine),
                        color = White
                    )
                }
            }
        }
    }
}