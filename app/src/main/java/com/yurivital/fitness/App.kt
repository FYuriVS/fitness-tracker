package com.yurivital.fitness

import android.app.Application
import com.yurivital.fitness.model.AppDatabase

class App: Application() {

    lateinit var db: AppDatabase
    override fun onCreate() {
        super.onCreate()

        db = AppDatabase.getDatabase(this)
    }
}