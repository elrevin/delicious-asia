package me.elrevin.onboarding_presentation.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.AppPrimaryTextIconButton
import me.elrevin.onboarding_presentation.viewmodel.OnboardingClassState
import me.elrevin.onboarding_presentation.viewmodel.OnboardingScreenVm
import me.elrevin.core_ui.R as CoreUiRes


@Composable
fun OnboardingScreen(
    onStartCooking: () -> Unit,
    onLogin: () -> Unit,
    vm: OnboardingScreenVm = hiltViewModel<OnboardingScreenVm>()
) {
    val state = vm.state

    val spaceHeight by animateDpAsState(
        targetValue = if (state is OnboardingClassState.LoadingIsSuccessful)
            72.dp
        else
            296.dp,
        finishedListener = {
            if ((state as OnboardingClassState.LoadingIsSuccessful).userAuthorizedOrSkipped) {
                onStartCooking()
            } else {
                onLogin()
            }
        }, label = "",
        animationSpec = tween(1000)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = CoreUiRes.drawable.onboarding_background),
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
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Find the best recipes from\nthe Central Asian nations",
                style = AppTheme.typography.body,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(100.dp))

            if (state is OnboardingClassState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp)
                )
            }

        }
    }
}