package com.achmadss.mvi.feature.main.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.achmadss.mvi.base.navigation.NavigationEvents
import com.achmadss.mvi.base.navigation.Route
import com.achmadss.mvi.base.ui.UIWrapper
import com.achmadss.mvi.feature.library.presentation.routeLibrary
import com.achmadss.mvi.feature.user_details.presentation.routeUserDetails

@Composable
fun MainScreen() = UIWrapper(hiltViewModel<MainViewModel>()) {
    val navController = rememberNavController()
    NavigationEvents(
        navigationChannel = navigator.navigationChannel,
        navHostController = navController
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Route.Library().path,
        ) {
            routeLibrary(Route.Library(), paddingValues)
            routeUserDetails(Route.UserDetails(), paddingValues)
        }
    }
}