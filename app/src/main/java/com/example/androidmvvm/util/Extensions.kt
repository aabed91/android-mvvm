package com.example.androidmvvm.util

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.androidmvvm.R

fun Fragment.showMessageDialog(message: String){
    val alert = AlertDialog.Builder(requireActivity())

    alert.setMessage(message)

    alert.setPositiveButton(R.string.ok){
            dialogInterface, i ->
        dialogInterface.dismiss()
    }

    alert.create().show()
}

fun Fragment.showErrorMessageDialog(){
    val alert = AlertDialog.Builder(requireActivity())

    alert.setMessage(R.string.err_intenet_connection)

    alert.setPositiveButton(R.string.ok){
            dialogInterface, i ->
        dialogInterface.dismiss()
    }

    alert.create().show()
}