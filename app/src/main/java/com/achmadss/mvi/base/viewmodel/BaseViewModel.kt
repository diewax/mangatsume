package com.achmadss.mvi.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmadss.mvi.base.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Intent>(
    initialState: State,
    val navigator: Navigator,
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> get() = _state

    // Abstract function to handle intent and update state
    abstract suspend fun handleIntent(intent: Intent)

    fun commit(intent: Intent) {
        viewModelScope.launch {
            handleIntent(intent)
        }
    }

    // update state
    fun commit(update: State.() -> State) {
        _state.value = _state.value.update()
    }

    suspend fun navigateBackAsync(
        route: String? = null,
        inclusive: Boolean = false,
    ) {
        navigator.navigateBackAsync(route, inclusive)
    }

    fun navigateBack(
        route: String? = null,
        inclusive: Boolean = false,
    ) {
        navigator.navigateBack(route, inclusive)
    }

    suspend fun navigateToAsync(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    ) {
        navigator.navigateToAsync(route, popUpToRoute, inclusive, isSingleTop)
    }

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    ) {
        navigator.navigateTo(route, popUpToRoute, inclusive, isSingleTop)
    }

}
