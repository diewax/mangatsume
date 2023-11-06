package com.achmadss.mvi.feature.main.presentation

import com.achmadss.domain.repositories.manga.MangaRepository
import com.achmadss.mvi.base.navigation.Navigator
import com.achmadss.mvi.base.viewmodel.BaseViewModel
import com.achmadss.mvi.feature.main.model.MainIntent
import com.achmadss.mvi.feature.main.model.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mangaRepository: MangaRepository,
    navigator: Navigator
): BaseViewModel<MainState, MainIntent>(
    initialState = MainState(),
    navigator = navigator
) {

    override suspend fun handleIntent(intent: MainIntent) {
        when(intent) {
            is MainIntent.NavigateToBrowse -> TODO()
            is MainIntent.NavigateToHistory -> TODO()
            is MainIntent.NavigateToLibrary -> TODO()
            is MainIntent.NavigateToMore -> TODO()
            is MainIntent.NavigateToUpdates -> TODO()
        }
    }

}