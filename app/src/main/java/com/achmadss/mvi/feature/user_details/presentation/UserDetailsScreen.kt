package com.achmadss.mvi.feature.user_details.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.achmadss.mvi.base.navigation.Route
import com.achmadss.mvi.base.ui.UIWrapper
import com.achmadss.mvi.feature.user_details.model.UserDetailsIntent

fun NavGraphBuilder.routeUserDetails(
    route: Route,
    paddingValues: PaddingValues,
) {
    composable(
        route = route.path,
        arguments = route.arguments
    ) { backStackEntry ->
        UIWrapper(hiltViewModel<UserDetailsViewModel>()) {
            val firstName = backStackEntry.arguments?.getString(Route.UserDetails.FIRST_NAME).orEmpty()
            val lastName = backStackEntry.arguments?.getString(Route.UserDetails.LAST_NAME).orEmpty()
            LaunchedEffect(Unit) {
                commit(UserDetailsIntent.LoadData(firstName, lastName))
            }
            UserDetailsScreen(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding(),
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                    ),
                loading = it.loading,
                text = "${it.firstName} ${it.lastName}"
            )
            BackHandler { navigateBack() }
        }
    }
}

@Composable
fun UserDetailsScreen(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    text: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loading) {
            CircularProgressIndicator()
        } else {
            Text(text = text)
        }
    }
}