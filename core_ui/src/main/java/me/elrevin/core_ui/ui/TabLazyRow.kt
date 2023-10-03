package me.elrevin.core_ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.utils.radialShimmerEffect

@Composable
fun TabLazyRow(
    modifier: Modifier = Modifier,
    list: List<Pair<Any, String>?>,
    activeTag: Any,
    onTabClick: (tag: Any) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(list.size) {
            val tab = list[it]
            if (tab != null) {
                TabButton(
                    text = tab.second,
                    active = (activeTag == tab.first),
                    tag = tab.first,
                    onClick = onTabClick
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(132.dp, 34.dp)
                        .clip(AppTheme.shapes.medium)
                        .radialShimmerEffect(
                            AppTheme.colors.shimmerColor1,
                            AppTheme.colors.shimmerColor2
                        ),
                )
            }
        }
    }
}