package com.achmadss.mvi.feature.user_details.model

data class UserDetailsState (
    val firstName: String = "", // initial value must be NOT NULL
    val lastName: String = "", // initial value must be NOT NULL
    val loading: Boolean = false,
    val errorMessage: String? = null
)