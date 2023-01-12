package com.example.informationbin.data.localSerivce

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.informationbin.data.emptities.HistoryElement

@Database(entities = [HistoryElement::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}