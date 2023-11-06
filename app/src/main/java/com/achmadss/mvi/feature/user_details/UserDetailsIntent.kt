package com.achmadss.mvi.feature.user_details

sealed class UserDetailsIntent {
    data class LoadData(
        val firstName: String,
        val lastName: String
    ): UserDetailsIntent()
}