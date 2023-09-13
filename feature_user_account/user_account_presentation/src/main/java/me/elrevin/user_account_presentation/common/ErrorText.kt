package me.elrevin.user_account_presentation.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import me.elrevin.core_ui.R
import me.elrevin.core_ui.theme.AppTheme

@Composable
internal fun ErrorText(code: Int) {
    val message = when(code) {
        1  -> stringResource(id = R.string.api_exception)
        11 -> stringResource(id = R.string.error11)
        12 -> stringResource(id = R.string.error12)
        13 -> stringResource(id = R.string.error13)
        14 -> stringResource(id = R.string.error14)
        15 -> stringResource(id = R.string.error15)
        else -> ""
    }

    if (message.isNotEmpty()) {
        Text(
            text = message,
            style = AppTheme.typography.label,
            color = AppTheme.colors.error
        )

    }
}