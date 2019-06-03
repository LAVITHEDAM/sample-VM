package com.example.context.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.example.context.R
import com.example.context.databinding.ActivityListBinding
import com.example.context.databinding.ActivityMainContextBinding
import com.example.context.viewModel.DeveloperViewModel
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var fm: FragmentManager = supportFragmentManager
    lateinit var viewModel: DeveloperViewModel
    lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        binding = DataBindingUtil.setContentView(this@ListActivity, R.layout.activity_list)
        viewModel = ViewModelProviders.of(this).get(DeveloperViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        addFragment()

        back_text_view.setOnClickListener() {
            onBackPressed()
        }
    }

    private fun addFragment() {
        val fragment = DeveloperListFragment()
        val ft = fm.beginTransaction()
        ft.add(R.id.frame_layout, fragment)
        ft.commitAllowingStateLoss()
    }


}
