package me.elrevin.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import me.elrevin.core_ui.R

object Icons {
    val arrowRight: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_arrow_right)
    val user: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_user)
    val key: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_key)
    val badge: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_user_badge)
    val star: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_star)
    val bookmark: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_bookmark)
}