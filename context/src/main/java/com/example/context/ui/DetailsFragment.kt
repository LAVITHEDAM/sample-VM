package com.example.context.ui


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.context.R
import com.example.context.viewModel.DeveloperViewModel
import kotlinx.android.synthetic.main.fragment_details.*
import java.util.*

class DetailsFragment : Fragment() {


    lateinit var viewModel: DeveloperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(DeveloperViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        setData(bundle!!.getInt("position"))
    }

    private fun setData(pos: Int) {
        val dev = viewModel.devList[pos]
        dev_name_text_View.text = dev.name
        dev_tech_text_View.text = dev.technology
        dev_exp_text_View.text = dev.experience.toString()

    }

}
