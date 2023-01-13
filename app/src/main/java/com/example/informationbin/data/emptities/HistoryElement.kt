package com.example.informationbin.data.emptities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "history")
data class HistoryElement(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "bin") val bin: String?
)
