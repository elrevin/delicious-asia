package me.elrevin.core_ui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    list: List<Pair<Any, String>>,
    activeTag: Any,
    onTabClick: (tag: Any) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        repeat(list.size) {
            val tab = list[it]
            TabButton(
                modifier = Modifier.weight(1f),
                text = tab.second,
                active = (activeTag == tab.first),
                tag = tab.first,
                onClick = onTabClick
            )
        }
    }
}