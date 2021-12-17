package com.atuwayli.mystory

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(val storiesList: ArrayList<Story>,val context: Context):
    RecyclerView.Adapter<CustomAdapter.DataHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val dataHolder: DataHolder = DataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story: Story = storiesList[position]
        holder.storyLetter.text = story.title.first().toString()
        holder.tvTitle.text = story.title
        holder.tvSubTitle.text = story.subTitle

        generateColor(holder,position)

        holder.itemView.setOnClickListener {
            val i = Intent(context,StoryDetailsActivity::class.java)
            i.putExtra("title",story.title)
            i.putExtra("desc",story.description)
            context.startActivity(i)
        }
    }

    private fun generateColor(holder: DataHolder,position: Int){
        val r = Random()
        val red = r.nextInt(255+position)
        val green = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red,green,blue))
    }

    override fun getItemCount(): Int {
        return storiesList.size
    }

    class DataHolder(view: View) : RecyclerView.ViewHolder(view) {
        val storyLetter: TextView = view.findViewById(R.id.storyLetter)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvSubTitle: TextView = view.findViewById(R.id.tvSubTitle)
        val cardViewLetter: CardView = view.findViewById(R.id.circle)


    }
}