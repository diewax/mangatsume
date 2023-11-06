package com.achmadss.mvi.feature.library.model

sealed class LibraryIntent {
    object LoadData: LibraryIntent()
    data class ButtonClicked(
        val firstName: String,
        val lastName: String
    ): LibraryIntent()
}