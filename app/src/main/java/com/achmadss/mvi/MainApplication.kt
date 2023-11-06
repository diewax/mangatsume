package com.achmadss.mvi

import android.app.Application
import com.achmadss.mvi.base.crash.CrashActivity
import com.achmadss.mvi.base.crash.GlobalExceptionHandler
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalExceptionHandler.initialize(applicationContext, CrashActivity::class.java)
//        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
//            val stackTrace = Log.getStackTraceString(throwable)
//            throwable.printStackTrace()
//            CrashActivity.launch(this, stackTrace)
//        }
    }

}