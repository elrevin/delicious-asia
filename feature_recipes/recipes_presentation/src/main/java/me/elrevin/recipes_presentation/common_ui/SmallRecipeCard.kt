package me.elrevin.recipes_presentation.common_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral50
import me.elrevin.core_ui.theme.Neutral80
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.TextLabelBold
import me.elrevin.core_ui.ui.TextSmall
import me.elrevin.core_ui.ui.TextSmallBold
import me.elrevin.core_ui.utils.radialShimmerEffect
import me.elrevin.recipes_domain.entity.Recipe

@Composable
fun SmallRecipeCard(
    recipe: Recipe?,
    onAddToFavorites: () -> Unit
) {
    Box(
        modifier = Modifier.size(150.dp, 231.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (recipe != null) {
            RecipeCard(recipe = recipe, onAddToFavorites = onAddToFavorites)
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(ShimmerShape())
                    .radialShimmerEffect(
                        AppTheme.colors.shimmerColor1,
                        AppTheme.colors.shimmerColor2
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(Neutral50.copy(alpha = 0.2f))
                )
                Box(
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 11.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(AppTheme.shapes.small)
                        .background(Neutral50.copy(alpha = 0.2f))
                )
                Box(
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 11.dp, bottom = 12.dp)
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(AppTheme.shapes.small)
                        .background(Neutral50.copy(alpha = 0.2f))
                )
            }
        }
    }
}

@Composable
private fun RecipeCard(
    recipe: Recipe,
    onAddToFavorites: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(176.dp)
            .background(AppTheme.colors.smallRecipeBackground, shape = AppTheme.shapes.large)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = recipe.mainPhoto,
            contentScale = ContentScale.Crop,
            contentDescription = recipe.name,
            modifier = Modifier
                .size(110.dp)
                .clip(
                    RoundedCornerShape(50)
                )
        )

        TextLabelBold(
            text = recipe.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 11.dp, bottom = 12.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                TextSmall(
                    text = stringResource(id = R.string.time),
                    color = AppTheme.colors.onSmallRecipeBackgroundSecond
                )

                TextSmallBold(
                    text = "${recipe.duration} ${stringResource(id = R.string.mins)}",
                    color = AppTheme.colors.onSmallRecipeBackgroundSecond
                )
            }

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(50))
                    .background(color = White)
                    .clickable {
                        onAddToFavorites()
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = AppTheme.icons.bookmark,
                    contentDescription = "",
                    tint = Neutral80
                )
            }
        }
    }
}

private class ShimmerShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(
        Path().apply {
            val width = size.width
            val height = size.height
            val densityPx = density.density

            val cornerRadius = 12f * densityPx
            val photoRadius = 55f * densityPx
            val shoulder = (width - photoRadius * 2f - cornerRadius * 2f) / 2f

            moveTo(0f, photoRadius)
            lineTo(cornerRadius + shoulder, photoRadius)
            arcTo(
                Rect(
                    cornerRadius + shoulder,
                    0f,
                    cornerRadius + shoulder + photoRadius * 2f,
                    photoRadius * 2f
                ),
                180f,
                180f,
                true
            )
            lineTo(width - cornerRadius, photoRadius)
            arcTo(
                Rect(
                    width - cornerRadius * 2f,
                    photoRadius,
                    width,
                    photoRadius + cornerRadius * 2f
                ),
                270f,
                90f,
                false
            )
            lineTo(
                width,
                height - cornerRadius
            )
            arcTo(
                Rect(
                    width - cornerRadius * 2f,
                    height - cornerRadius * 2f,
                    width,
                    height
                ),
                0f,
                90f,
                false
            )

            lineTo(cornerRadius, height)

            arcTo(
                Rect(
                    0f,
                    height - cornerRadius * 2,
                    cornerRadius * 2,
                    height
                ),
                90f,
                90f,
                false
            )

            lineTo(0f, photoRadius + cornerRadius )
            arcTo(
                Rect(
                    0f,
                    photoRadius,
                    cornerRadius * 2,
                    photoRadius + cornerRadius * 2
                ),
                180f,
                90f,
                false
            )
            close()
        }
    )
}