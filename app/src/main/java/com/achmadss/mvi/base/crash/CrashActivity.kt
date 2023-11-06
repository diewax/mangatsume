package com.achmadss.mvi.base.crash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat

class CrashActivity : ComponentActivity() {

//    private val stackTrace by lazy { intent.getStringExtra(EXTRA_STACK_TRACE) ?: "No stack trace available" }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val exception = GlobalExceptionHandler.getThrowableFromIntent(intent)
        setContent {
            CrashScreen(
                exception = exception,
                onRestartClick = ::restartApp,
                onCloseClick = ::closeApp
            )
        }
    }

    private fun restartApp() {
        val intent = packageManager.getLaunchIntentForPackage(packageName)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }
        startActivity(intent)
        finish()
    }

    private fun closeApp() {
        finish()
    }

//    companion object {
//        const val EXTRA_STACK_TRACE = "EXTRA_STACK_TRACE"
//
//        fun launch(context: Context, stackTrace: String) {
//            val intent = Intent(context, CrashActivity::class.java)
//                .setAction("application.crash")
//                .apply {
//                    putExtra(EXTRA_STACK_TRACE, stackTrace)
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                }
//            context.startActivity(intent)
//        }
//    }
}
