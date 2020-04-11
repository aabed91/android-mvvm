package com.example.androidmvvm.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData

@BindingAdapter("setProgressVisibility")
fun setProgressVisibility(view: View, showProgress: LiveData<Boolean>?){
    if(showProgress?.value!!){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

