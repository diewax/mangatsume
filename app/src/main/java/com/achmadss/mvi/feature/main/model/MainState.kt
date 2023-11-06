package com.achmadss.mvi.feature.main.model

data class MainState(
    val loading: Boolean = false,
    val errorMessage: String? = null
)