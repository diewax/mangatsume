package com.achmadss.mvi.base.crash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.achmadss.mvi.R
import com.achmadss.mvi.base.ui.InfoScreen
import com.achmadss.mvi.padding

@Composable
fun CrashScreen(
    exception: Throwable?,
    onRestartClick: () -> Unit,
    onCloseClick: () -> Unit,
) {
    InfoScreen(
        icon = Icons.Outlined.BugReport,
        headingText = stringResource(R.string.crash_screen_title),
        subtitleText = stringResource(R.string.crash_screen_description, stringResource(R.string.app_name)),
        acceptText = stringResource(R.string.crash_screen_restart_application),
        onAcceptClick = onRestartClick,
        rejectText = stringResource(R.string.crash_screen_close),
        onRejectClick = onCloseClick,
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = MaterialTheme.padding.small)
                .clip(MaterialTheme.shapes.small)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant),
        ) {
            Text(
                text = exception.toString(),
                modifier = Modifier
                    .padding(all = MaterialTheme.padding.small),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}