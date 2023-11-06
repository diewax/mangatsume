package com.achmadss.mvi.base.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.achmadss.mvi.base.viewmodel.BaseViewModel

@Composable
inline fun <reified VM : BaseViewModel<State, *>, State : Any> UIWrapper(
    viewModel: VM = viewModel(),
    crossinline content: @Composable VM.(State) -> Unit
) {
    val state by viewModel.state.collectAsState()
    // No need to cast state, as it should be automatically inferred from the ViewModel's state type
    viewModel.content(state)
}
