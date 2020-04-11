package com.example.androidmvvm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidmvvm.base.BaseViewModel

class HomeViewModel(var id : Int) : BaseViewModel() {

    private var _data = MutableLiveData<String>()
    val data : LiveData<String> = _data

    init {
        showProgress()
        getData()
    }

    private fun getData(){
        hideProgress()
        _data.value = "Data is $id"
    }
}
