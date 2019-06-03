package com.example.context.ui


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.context.R
import com.example.context.viewModel.DeveloperViewModel
import kotlinx.android.synthetic.main.fragment_developer_list.*


class DeveloperListFragment : Fragment() {

    lateinit var adapter: DeveloperAdapter

    lateinit var viewModel: DeveloperViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(DeveloperViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_developer_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = DeveloperAdapter(activity!!, viewModel.devList, listener)
        recycler_view.adapter = adapter
    }

    interface MyOnClickListener {
        fun onClick(position: Int)
    }

    private var listener: MyOnClickListener = object : MyOnClickListener {
        override fun onClick(position: Int) {
            val fragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putInt("position", position)
            fragment.arguments = bundle
            val ft = activity!!.supportFragmentManager.beginTransaction()
            ft.add(R.id.frame_layout, fragment)
            ft.commitAllowingStateLoss()
        }
    }


}
