package com.naveen.androidx.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naveen.androidx.R

/**
 * Created by Drish Infotech on 12/19/18.
This class is used in this project
 */
class RecyclerAdapter(val list: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = "Text : ${list[position]}"
        holder.textView1.text = "SubText : ${list[position]}"
    }


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val textView: TextView = item.findViewById(R.id.textView)
        val textView1: TextView = item.findViewById(R.id.textView2)
    }
}