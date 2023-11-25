package me.ppvan.metour.di

import android.content.Context
import me.ppvan.metour.repository.AuthService
import me.ppvan.metour.repository.RoomAuthService
import me.ppvan.metour.repository.RoomTourismRepository
import me.ppvan.metour.repository.TourismRepository

interface AppModule {
    val tourRepo: TourismRepository
    val authService: AuthService
}

class AppModuleImpl(private val appContext: Context) : AppModule {
    override val tourRepo: TourismRepository by lazy {
        RoomTourismRepository()
    }

    override val authService: AuthService by lazy {
        RoomAuthService()
    }
}

