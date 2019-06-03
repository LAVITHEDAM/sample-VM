package com.example.context.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.context.R
import com.example.context.databinding.ActivityMainContextBinding
import com.example.context.viewModel.ContextViewModel
import kotlinx.android.synthetic.main.activity_main_context.*

class MainContextActivity : AppCompatActivity() {

    lateinit var viewModel: ContextViewModel
    lateinit var binding: ActivityMainContextBinding
    var count1 = 0
    var count2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_context)
        viewModel = ViewModelProviders.of(this).get(ContextViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        if (savedInstanceState != null) {
            count2 = savedInstanceState.getInt("count2")
        }
        textview1.text = "Regular Count : $count1"
        textview2.text = "Saved Count : $count2"
        viewModel.text3.set("Observable Count : ${viewModel.count3}")

        setSubscriptions()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putInt("count2", count2)
        super.onSaveInstanceState(outState)
    }

    private fun setSubscriptions() {
        viewModel.onClickEvent.observe(this, Observer {
            when (it!!) {
                getDataTextView -> updateData()
                nextPageTextView -> {
                    val intent = Intent(this, ListActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }


    private fun updateData() {
        textview1.text = "Regular Count : ${++count1}"
        textview2.text = "Saved Count : ${++count2}"
        viewModel.text3.set("Observable Count : ${++viewModel.count3}")
    }
}
