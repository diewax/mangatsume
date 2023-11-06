package com.achmadss.mvi.base.navigation

import kotlinx.coroutines.channels.Channel

interface Navigator {
    val navigationChannel: Channel<NavigationIntent>

    suspend fun navigateBackAsync(
        route: String? = null,
        inclusive: Boolean = false,
    )

    fun navigateBack(
        route: String? = null,
        inclusive: Boolean = false,
    )

    suspend fun navigateToAsync(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}

sealed class NavigationIntent {
    data class NavigateBack(
        val route: String? = null,
        val inclusive: Boolean = false,
    ) : NavigationIntent()

    data class NavigateTo(
        val route: String,
        val popUpToRoute: String? = null,
        val inclusive: Boolean = false,
        val isSingleTop: Boolean = false,
    ) : NavigationIntent()
}