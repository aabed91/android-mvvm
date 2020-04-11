package com.example.androidmvvm.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(){



    private var _onBack = MutableLiveData<Boolean>()
    val onBack : LiveData<Boolean>
        get() = _onBack

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String>
        get() = _errorMessage

    private var _showProgress = MutableLiveData<Boolean>()
    val showProgress : LiveData<Boolean>
        get() = _showProgress

    private var _showFailureDialog = MutableLiveData<Boolean>()
    val showFailureDialog : LiveData<Boolean>
        get() = _showFailureDialog

    private var _done = MutableLiveData<Boolean>()
    val done : LiveData<Boolean>
        get() = _done

    init {
        _showProgress.value = false
    }

    fun onBackPressed(){
        _onBack.value = true
    }

    fun showErrorMessage(message: String){
        _errorMessage.value = message
    }

    fun showFailureDialog(){
        _showFailureDialog.value = true
    }

    fun showProgress(){
        _showProgress.value = true
    }

    fun hideProgress(){
        _showProgress.value = false
    }

    fun resetOnBack(){
        _onBack.value = false
    }

    fun resetErrorMessage(){
        _errorMessage.value = ""
    }

    fun resetFailureDialog(){
        _showFailureDialog.value = false
    }

    fun done(){
        _done.value = true
    }

    fun resetDone(){
        _done.value = false
    }

}