package me.elrevin.core_ui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabLazyRow(
    modifier: Modifier = Modifier,
    list: List<Pair<Any, String>>,
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
            TabButton(
                text = tab.second,
                active = (activeTag == tab.first),
                tag = tab.first,
                onClick = onTabClick
            )
        }
    }
}