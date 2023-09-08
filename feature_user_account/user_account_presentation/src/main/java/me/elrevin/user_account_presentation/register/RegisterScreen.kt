package me.elrevin.user_account_presentation.register

import androidx.compose.foundation.Image
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
import me.elrevin.core_ui.R as CoreUiRes
import me.elrevin.core_ui.theme.AppTheme
import me.elrevin.core_ui.theme.Neutral60
import me.elrevin.core_ui.theme.White
import me.elrevin.core_ui.ui.AppPrimaryLargeButton
import me.elrevin.core_ui.ui.AppSecondarySmallButton
import me.elrevin.core_ui.ui.AppTextField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(
    vm: RegisterScreenVM = hiltViewModel(),
    onSuccessfulRegister: () -> Unit,
    onAuth: () -> Unit,
    onSkip: () -> Unit,
) {
    val state = vm.state

    LaunchedEffect(key1 = state.registerSuccessful, block = {
        if (state.registerSuccessful) {
            onSuccessfulRegister()
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
            painter = painterResource(id = CoreUiRes.drawable.onboarding_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                text = "Create your account for using \nall functions:",
                style = AppTheme.typography.body,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(0.2f))

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.name,
                label = stringResource(id = CoreUiRes.string.name),
                prefixIconPainter = AppTheme.icons.badge,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                onValueChange = { vm.onEvent(RegisterScreenEvent.OnNameChange(it)) }
            )

            Spacer(modifier = Modifier.height(18.dp))

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
                onValueChange = { vm.onEvent(RegisterScreenEvent.OnLoginChange(it)) }
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
                        vm.onEvent(RegisterScreenEvent.OnRegisterButtonClick)
                    }
                ),
                onValueChange = { vm.onEvent(RegisterScreenEvent.OnPasswordChange(it)) }
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

                if (state.errorStr.isNotEmpty()) {
                    Text(
                        text = state.errorStr,
                        style = AppTheme.typography.label,
                        color = AppTheme.colors.error
                    )
                } else if (state.error != null) {
                    Text(
                        text = LocalContext.current.getString(state.error),
                        style = AppTheme.typography.label,
                        color = AppTheme.colors.error
                    )

                }
            }


            Spacer(modifier = Modifier.weight(1f))

            AppPrimaryLargeButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = CoreUiRes.string.create_an_account),
                iconPainter = AppTheme.icons.arrowRight,
                onClick = { vm.onEvent(RegisterScreenEvent.OnRegisterButtonClick) }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppSecondarySmallButton(
                    text = stringResource(id = CoreUiRes.string.skip),
                    onClick = {
                        vm.onEvent(RegisterScreenEvent.OnSkipButtonClick)
                    }
                )

                AppSecondarySmallButton(
                    text = stringResource(id = CoreUiRes.string.sign_in),
                    onClick = { onAuth() }
                )
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}