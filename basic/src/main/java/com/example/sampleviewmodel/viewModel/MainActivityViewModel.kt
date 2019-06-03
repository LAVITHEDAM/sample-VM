package com.example.sampleviewmodel.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.view.View
import com.example.sampleviewmodel.model.MainActivityModel

class MainActivityViewModel : ViewModel() {

    var onClickEvent = MutableLiveData<View>()
    var updateDataEvent = MutableLiveData<Void>()

//    var text1 = ObservableField("")
//    var text2 = ObservableField("")
//    var text3 = ObservableField("")

    var mainActivityModel = MainActivityModel()

    fun updateData(count: Int) {
//        text1.set("text one $count")
//        text2.set("text two $count")
//        text3.set("text three $count")

        mainActivityModel.modelText1 = "text one $count"
        mainActivityModel.modelText2 = "text two $count"
        mainActivityModel.modelText3 = "text three $count"
        updateDataEvent.value = null
    }

    fun onClick(view: View) {
        onClickEvent.value = view
    }
}