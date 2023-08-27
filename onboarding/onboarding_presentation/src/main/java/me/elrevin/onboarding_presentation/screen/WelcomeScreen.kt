package me.elrevin.onboarding_presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.elrevin.onboarding_presentation.R
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.AppPrimaryTextIconButton


@Composable
fun WelcomeScreen(
    onStartCooking: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier.padding(start = 50.dp, end = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Delicious\nAsia",
                style = AppTheme.typography.head,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Find the best recipes from\nthe Central Asian nations",
                style = AppTheme.typography.body,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(138.dp))
            AppPrimaryTextIconButton(
                text = "Start cooking",
                iconPainter = AppTheme.icons.arrowRight
            ) {
                onStartCooking()
            }
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}