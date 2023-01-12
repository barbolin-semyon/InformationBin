package com.example.informationbin

import android.app.Application
import androidx.room.Room
import com.example.informationbin.data.localSerivce.AppDatabase

class App : Application() {

    companion object {
        lateinit var roomDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        roomDatabase = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "history"
        ).build()
    }
}