package com.example.informationbin.data

import android.app.Application
import androidx.room.Room
import com.example.informationbin.App
import com.example.informationbin.data.emptities.BinDetail
import com.example.informationbin.data.emptities.HistoryElement
import com.example.informationbin.data.networkService.BINService
import com.example.informationbin.data.networkService.RetrofitClient
import kotlinx.coroutines.withContext
import retrofit2.Call

object Repository {
    private val localDb = App.roomDatabase.historyDao()
    private val networkDb = RetrofitClient.getRetrofitService().create(BINService::class.java)

    fun getBinInformation(bin: String): Call<BinDetail> {
        return networkDb.getBinInformation(bin)
    }

    suspend fun getHistory(): List<HistoryElement> {
        return localDb.getAll()
    }

    suspend fun addElementInHistory(historyElement: HistoryElement) {
        return localDb.insert(historyElement)
    }

    suspend fun deleteHistory(historyElement: HistoryElement) {
        return localDb.delete(historyElement)
    }
}