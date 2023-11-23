package me.ppvan.metour

import android.app.Application
import me.ppvan.metour.di.AppModule
import me.ppvan.metour.di.AppModuleImpl

class MeTourApplication : Application() {

    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}