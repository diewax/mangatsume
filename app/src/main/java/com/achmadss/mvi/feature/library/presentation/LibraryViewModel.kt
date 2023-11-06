package com.achmadss.mvi.feature.library.presentation

import com.achmadss.mvi.base.viewmodel.BaseViewModel
import com.achmadss.mvi.base.navigation.Navigator
import com.achmadss.mvi.feature.library.model.LibraryIntent
import com.achmadss.mvi.feature.library.model.LibraryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    navigator: Navigator,
): BaseViewModel<LibraryState, LibraryIntent>(
    initialState = LibraryState(),
    navigator = navigator
) {

    override suspend fun handleIntent(intent: LibraryIntent) {
        when (intent) {
            is LibraryIntent.LoadData -> handleLoadData()
            is LibraryIntent.ButtonClicked -> handleButtonClicked(intent)
        }
    }

    private suspend fun handleLoadData() {
        commit { copy(loading = true) }
        delay(1500) // simulate loading
        commit { copy(data = "Data Loaded!", loading = false) }
    }

    private suspend fun handleButtonClicked(intent: LibraryIntent.ButtonClicked) {
        commit { copy(loading = true) }
        delay(1500) // simulate loading
        val fullName = "${intent.firstName} ${intent.lastName}"
        commit { copy(data = fullName, loading = false, errorMessage = fullName) }
    }

}