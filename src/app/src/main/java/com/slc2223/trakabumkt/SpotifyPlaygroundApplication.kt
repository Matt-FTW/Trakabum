package com.slc2223.trakabumkt

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

/**
 * This class is the entry point of the application.
 * It is used to initialize the application and its components.
 */
class SpotifyPlaygroundApplication : Application() {
    lateinit var model: Model // This is a singleton object that is used to store data that is used across the application.

    /**
     * This method is called when the application is starting, before any other application objects have been created.
     */
    override fun onCreate() {
        super.onCreate()
        model = Model
        context = applicationContext
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) // This line is used to set the theme of the application to follow the system theme.
    }

    /**
     * This companion object is used to store static variables and methods.
     * In this case, it is used to store the application context.
     */
    companion object {
        lateinit var context: Context
    }
}