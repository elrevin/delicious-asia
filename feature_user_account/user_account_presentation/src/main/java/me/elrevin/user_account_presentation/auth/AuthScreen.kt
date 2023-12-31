package me.elrevin.user_account_presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral60
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.AppPrimaryLargeButton
import me.elrevin.core_ui.ui.AppSecondarySmallButton
import me.elrevin.core_ui.ui.AppTextField
import me.elrevin.user_account_presentation.common.ErrorText
import me.elrevin.core_ui.R as CoreUiRes

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AuthScreen(
    state: AuthScreenState,
    onLoginChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onAuthButtonClick: () -> Unit,
    onSkipButtonClick: () -> Unit,
    onSuccessfulAuth: () -> Unit,
    onRegister: () -> Unit,
    onSkip: () -> Unit,
) {
    LaunchedEffect(key1 = state.authSuccessful, block = {
        if (state.authSuccessful) {
            onSuccessfulAuth()
        }
    })

    LaunchedEffect(key1 = state.skipAuthorization, block = {
        if (state.skipAuthorization) {
            onSkip()
        }
    })

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(54.dp))
            Text(
                text = "Delicious\nAsia",
                style = AppTheme.typography.head,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "The app maybe more useful \nif you are logged in:",
                style = AppTheme.typography.body,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(0.2f))

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.login,
                label = stringResource(id = CoreUiRes.string.login),
                prefixIconPainter = AppTheme.icons.user,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                onValueChange = onLoginChange
            )

            Spacer(modifier = Modifier.height(18.dp))

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.password,
                label = stringResource(id = CoreUiRes.string.password),
                visualTransformation = PasswordVisualTransformation(),
                prefixIconPainter = AppTheme.icons.key,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        onAuthButtonClick()
                    }
                ),
                onValueChange = onPasswordChange
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(42.dp),
                contentAlignment = Alignment.Center
            ) {
                if (state.progressVisible) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(32.dp),
                        color = Neutral60,
                        trackColor = Color.Transparent
                    )
                }

                if (state.error != null) {
                    ErrorText(code = state.error)
                }
            }


            Spacer(modifier = Modifier.weight(1f))

            AppPrimaryLargeButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = CoreUiRes.string.start_cooking),
                iconPainter = AppTheme.icons.arrowRight,
                onClick = onAuthButtonClick
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppSecondarySmallButton(
                    text = stringResource(id = CoreUiRes.string.skip),
                    onClick = onSkipButtonClick
                )

                AppSecondarySmallButton(
                    text = stringResource(id = CoreUiRes.string.register),
                    onClick = { onRegister() }
                )
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}