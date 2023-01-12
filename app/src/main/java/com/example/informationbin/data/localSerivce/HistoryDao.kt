package com.example.informationbin.data.localSerivce

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.informationbin.data.emptities.HistoryElement

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getAll(): List<HistoryElement>

    @Insert
    fun insert(vararg historyElement: HistoryElement)

    @Delete
    fun delete(historyElement: HistoryElement)
}
