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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral80
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.TextLabelBold
import me.elrevin.core_ui.ui.TextSmall
import me.elrevin.core_ui.ui.TextSmallBold
import me.elrevin.recipes_domain.entity.Recipe

@Composable
fun SmallRecipeCard(
    recipe: Recipe,
    onAddToFavorites: () -> Unit
) {
    Box(
        modifier = Modifier.size(150.dp, 231.dp),
        contentAlignment = Alignment.BottomCenter
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
}