package com.example.informationbin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.informationbin.data.Repository
import com.example.informationbin.data.emptities.BinDetail
import com.example.informationbin.data.emptities.HistoryElement
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class BinViewModel : ViewModel() {
    private val repository = Repository

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _detailInformation by lazy { MutableLiveData<BinDetail>(null) }
    val detailInformation: LiveData<BinDetail>
        get() = _detailInformation

    private val _history by lazy {MutableLiveData<List<HistoryElement>>(listOf())}
    val history: LiveData<List<HistoryElement>>
        get() = _history

    private fun getCurrentDateStringType(): String {
        val date = Calendar.getInstance()
        val format = SimpleDateFormat("dd.MMMM.yyyy", Locale("ru"))
        return format.format(date.time)
    }

    private fun addElementInHistory(bin: String) = viewModelScope.launch {
        val date = getCurrentDateStringType()

        val element = HistoryElement(bin = bin, date = date)

        async { repository.addElementInHistory(element) }.await()
        _isLoading.value = false
    }

    fun getBinInformation(bin: String) {
        _isLoading.value = true

        repository.getBinInformation(bin).enqueue(object : Callback<BinDetail> {
            override fun onResponse(call: Call<BinDetail>, response: Response<BinDetail>) {
                _detailInformation.value = response.body()
                addElementInHistory(bin)
            }

            override fun onFailure(call: Call<BinDetail>, t: Throwable) {
                _isLoading.value = false
            }
        })
    }

    fun getHistory() = viewModelScope.launch {
        _isLoading.value = true
        val result = async { repository.getHistory() }.await()
        _history.value = result
        _isLoading.value = false
    }

    fun deleteHistory(historyElement: HistoryElement) = viewModelScope.launch {
        _isLoading.value = true
        async { repository.deleteHistory(historyElement) }.await()
        _isLoading.value = false
    }
}