package me.elrevin.user_account_presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import me.elrevin.core_ui.R as CoreUiRes
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.AppPrimaryTextIconButton
import me.elrevin.core_ui.ui.AppTextField

@Composable
fun AuthScreen(
    onSuccessfulLogin: () -> Unit,
    onRegister: () -> Unit,
    onSkip: () -> Unit
) {
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
            Spacer(modifier = Modifier.height(72.dp))
            Text(
                text = "Delicious\nAsia",
                style = AppTheme.typography.head,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "The app maybe more useful \nif you are logged in:",
                style = AppTheme.typography.body,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(44.dp))

            AppTextField(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                value = "sefdsf",
                label = "sdfsd"
            )

            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}