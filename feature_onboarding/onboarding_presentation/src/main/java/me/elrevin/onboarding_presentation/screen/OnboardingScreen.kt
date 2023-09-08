package me.elrevin.onboarding_presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral60
import me.elrevin.core_ui.theme.White
import me.elrevin.onboarding_presentation.viewmodel.OnboardingScreenVm


@Composable
fun OnboardingScreen(
    onStartCooking: () -> Unit,
    onLogin: () -> Unit,
    vm: OnboardingScreenVm = hiltViewModel()
) {
    val state = vm.state

    LaunchedEffect(key1 = state.authorizedOrSkipped, block = {
        if (state.authorizedOrSkipped) {
            delay(700)
            onStartCooking()
        }
    })

    LaunchedEffect(key1 = state.unAuthorized, block = {
        if (state.unAuthorized) {
            onLogin()
        }
    })

    val spaceHeight by animateDpAsState(
        targetValue = if (state.unAuthorized)
            54.dp
        else
            296.dp,
        finishedListener = {
            onLogin()
        }, label = "",
        animationSpec = tween(1000)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier.padding(start = 50.dp, end = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(spaceHeight))
            Text(
                text = "Delicious\nAsia",
                style = AppTheme.typography.head,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            AnimatedContent(
                targetState =
                if (spaceHeight < 150.dp)
                    "The app maybe more useful \nif you are logged in:"
                else
                    "Find the best recipes from\nthe Central Asian nations",
                transitionSpec = {
                    fadeIn().togetherWith(fadeOut())
                }, label = ""
            ) {
                Text(
                    text = it,
                    style = AppTheme.typography.body,
                    color = White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

            }

            Spacer(modifier = Modifier.height(100.dp))

            if (state.loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(32.dp),
                    color = Neutral60,
                    trackColor = Color.Transparent
                )
            }

        }
    }
}