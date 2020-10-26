package com.example.rk_tarasova

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HostViewModel: ViewModel(){
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
    get() = _response
    init {
        loadDataFromInternet()
    }
    private fun loadDataFromInternet(){
        viewModelScope.launch {
            try{
                val listResult = ExampleApi.retrofitService.getData()
                _response.value = "Success: ${listResult.size} data retrieved"
            }catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}