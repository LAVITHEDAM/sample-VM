package com.example.sampleviewmodel.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

class MainActivityModel : BaseObservable() {

    @get:Bindable
    var modelText1: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.modelText1)
        }
    @get:Bindable
    var modelText2: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.modelText2)
        }
    @get:Bindable
    var modelText3: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.modelText3)
        }
}