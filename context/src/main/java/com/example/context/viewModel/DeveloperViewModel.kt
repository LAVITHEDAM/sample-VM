package com.example.context.viewModel

import android.arch.lifecycle.ViewModel
import com.example.context.model.Developer

class DeveloperViewModel : ViewModel() {

    var devList: MutableList<Developer> = ArrayList()

    init {
        devList.add(Developer("Lavith", "Android", 3))
        devList.add(Developer("Laxman", "iOS", 1))
        devList.add(Developer("Salman", "Angular", 13))
        devList.add(Developer("fasak", "React", 18))
    }

}