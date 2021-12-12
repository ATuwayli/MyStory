package com.atuwayli.mystory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val array: ArrayList<Story>) : RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val dataHolder: DataHolder = DataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val person: Story = array[position]
        holder.imageText.text = person.imageText
        holder.tvTitle.text = person.title
        holder.tvSubTitle.text = person.subTitle
    }

    override fun getItemCount(): Int {
        return array.size
    }

    class DataHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageText: TextView = view.findViewById(R.id.imageText)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvSubTitle: TextView = view.findViewById(R.id.tvSubTitle)
    }
}