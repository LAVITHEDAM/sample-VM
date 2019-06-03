package com.example.context.ui

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.context.R
import com.example.context.model.Developer

class DeveloperAdapter(
    private val context: Context,
    private var devList: MutableList<Developer>,
    var listener: DeveloperListFragment.MyOnClickListener
) :
    RecyclerView.Adapter<DeveloperAdapter.DevViewHolder>() {

    inner class DevViewHolder(view: View, listener: DeveloperListFragment.MyOnClickListener) :
        RecyclerView.ViewHolder(view) {
        var layout: ConstraintLayout = view.findViewById(R.id.dev_layout)
        var name: TextView = view.findViewById(R.id.name_text_View)
        var tech: TextView = view.findViewById(R.id.tech_text_View)
        var exp: TextView = view.findViewById(R.id.exp_text_View)

        init {
            layout.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DevViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.developer_item, p0, false)
        return DevViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: DevViewHolder, p1: Int) {
        val dev = devList[p1]
        holder.name.text = dev.name
        holder.tech.text = dev.technology
        holder.exp.text = dev.experience.toString()
    }

    override fun getItemCount(): Int {
        return devList.size
    }

}
