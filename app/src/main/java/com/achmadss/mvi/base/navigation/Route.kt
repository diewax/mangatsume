package com.achmadss.mvi.base.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Route(private val routeName: String, private vararg val params: Pair<String, String?>) {

    abstract val arguments: List<NamedNavArgument>

    val path: String by lazy {
        buildString {
            append(routeName)
            params.forEach { (paramName, paramValue) ->
                append("/")
                append(paramValue ?: "{$paramName}")
            }
        }
    }

    // START
    class Library : NoArgumentsRoute("library")

    class UserDetails(firstName: String? = null, lastName: String? = null) : Route(
        "user_details",
        FIRST_NAME to firstName, LAST_NAME to lastName
    ) {
        companion object {
            const val FIRST_NAME = "first_name"
            const val LAST_NAME = "last_name"
        }
        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(FIRST_NAME) { type = NavType.StringType },
                navArgument(LAST_NAME) { type = NavType.StringType }
            )
    }
    // END

}

sealed class NoArgumentsRoute(routeName: String) : Route(routeName) {
    override val arguments: List<NamedNavArgument> = emptyList()
}

// returns "user_details/{first_name}/{last_name}"
val userDetailsRoute = Route.UserDetails().path

// returns "user_details/John/Doe"
val userDetailsRouteWithParams = Route.UserDetails("John", "Doe").path
