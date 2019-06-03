package com.example.sampleviewmodel.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.sampleviewmodel.R
import com.example.sampleviewmodel.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: com.example.sampleviewmodel.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        setSubscriptions()
    }

    private fun setSubscriptions() {
        viewModel.updateDataEvent.observe(this, Observer {
            Toast.makeText(this, "data updated from view model", Toast.LENGTH_LONG).show()
        })

        viewModel.onClickEvent.observe(this, Observer {
            viewModel.updateData(++count)
        })
    }
}
