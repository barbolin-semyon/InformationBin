package com.example.informationbin.data.emptities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class HistoryElement(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "bin") val bin: String?
)
