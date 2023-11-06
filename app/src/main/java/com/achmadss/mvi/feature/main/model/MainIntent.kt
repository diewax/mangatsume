package com.achmadss.mvi.feature.main.model

import androidx.compose.runtime.Immutable

@Immutable
sealed class MainIntent {
    object NavigateToLibrary : MainIntent()
    object NavigateToUpdates : MainIntent()
    object NavigateToHistory : MainIntent()
    object NavigateToBrowse : MainIntent()
    object NavigateToMore : MainIntent()
}