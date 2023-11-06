package com.achmadss.mvi.feature.library.presentation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.achmadss.mvi.base.navigation.Route
import com.achmadss.mvi.base.ui.UIWrapper
import com.achmadss.mvi.feature.library.model.LibraryIntent

fun NavGraphBuilder.routeLibrary(
    route: Route,
    paddingValues: PaddingValues,
) {
    composable(
        route = route.path,
        arguments = route.arguments
    ) {
        UIWrapper(hiltViewModel<LibraryViewModel>()) {
            val ctx = LocalContext.current

            LaunchedEffect(Unit) {
                commit(LibraryIntent.LoadData)
            }

            LibraryScreen(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding(),
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                    ),
                loading = it.loading,
                text = it.data,
                onButtonClicked = { firstName, lastName ->
                    commit(LibraryIntent.ButtonClicked(firstName, lastName))
                },
                onNavigate = { firstName, lastName ->
                    navigateTo(Route.UserDetails(firstName, lastName).path)
                }
            )

            BackHandler { navigateBack() }

            LaunchedEffect(it.errorMessage) {
                it.errorMessage?.let { message ->
                    Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

@Composable
fun LibraryScreen(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    text: String,
    onButtonClicked: (String, String) -> Unit,
    onNavigate: (String, String) -> Unit,
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loading) {
            CircularProgressIndicator()
        } else {
            Text(text = text)
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("Enter firstname") }
            )
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Enter lastname") }
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onButtonClicked(firstName, lastName) }
            ) {
                Text("Submit")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigate(firstName, lastName) }
            ) {
                Text("Navigate to User Details")
            }
        }
    }
}