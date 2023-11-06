package com.achmadss.mvi.feature.user_details.presentation

import com.achmadss.mvi.base.navigation.Navigator
import com.achmadss.mvi.base.viewmodel.BaseViewModel
import com.achmadss.mvi.feature.user_details.UserDetailsIntent
import com.achmadss.mvi.feature.user_details.UserDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    navigator: Navigator,
): BaseViewModel<UserDetailsState, UserDetailsIntent>(
    initialState = UserDetailsState(),
    navigator = navigator
) {

    override suspend fun handleIntent(intent: UserDetailsIntent) {
        when(intent) {
            is UserDetailsIntent.LoadData -> handleLoadData(intent)
        }
    }

    private suspend fun handleLoadData(intent: UserDetailsIntent.LoadData) {
        commit { copy(loading = true) }
        delay(1500) // simulate loading
        commit {
            copy(
                firstName = intent.firstName,
                lastName = intent.lastName,
                loading = false
            )
        }
    }

}