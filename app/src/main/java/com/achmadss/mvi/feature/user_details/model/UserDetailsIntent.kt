package com.achmadss.mvi.feature.user_details.model

sealed class UserDetailsIntent {
    data class LoadData(
        val firstName: String,
        val lastName: String
    ): UserDetailsIntent()
}