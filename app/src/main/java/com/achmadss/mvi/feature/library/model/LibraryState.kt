package com.achmadss.mvi.feature.library.model

import androidx.compose.runtime.Immutable

@Immutable
data class LibraryState(
    val data: String = "", // initial value must be NOT NULL
    val loading: Boolean = false,
    val errorMessage: String? = null
)