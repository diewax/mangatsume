package com.achmadss.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.achmadss.mvi.base.navigation.Navigator
import com.achmadss.mvi.feature.main.presentation.MainScreen
import com.achmadss.mvi.ui.theme.MviTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MviTheme {
                MainScreen()
            }
        }
    }
}