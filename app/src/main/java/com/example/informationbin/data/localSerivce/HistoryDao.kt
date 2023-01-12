package com.example.informationbin.data.localSerivce

import androidx.room.*
import com.example.informationbin.data.emptities.HistoryElement

@Dao
interface HistoryDao {
    @Transaction
    @Query("SELECT * FROM history")
    suspend fun getAll(): List<HistoryElement>

    @Insert
    suspend fun insert(vararg historyElement: HistoryElement)

    @Delete
    suspend fun delete(historyElement: HistoryElement)
}
