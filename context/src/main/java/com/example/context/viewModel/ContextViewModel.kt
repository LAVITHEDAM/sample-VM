package com.example.context.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast

class ContextViewModel(application: Application) : AndroidViewModel(application) {

//    lateinit var context :Context

    var onClickEvent = MutableLiveData<View>()
    var count3 = 0

    var text3 = ObservableField("")

    fun onClick(view: View) {
        onClickEvent.value = view
        Toast.makeText(getApplication(), "Clicked", Toast.LENGTH_SHORT).show() //UI operations not allowed here.....
    }

}