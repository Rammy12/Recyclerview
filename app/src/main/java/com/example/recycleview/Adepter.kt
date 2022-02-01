package com.example.recycleview

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adepter(private val newslist:ArrayList<News>): RecyclerView.Adapter<Adepter.Myviewholder>() {
    private lateinit var mlistener:onItemClicklistener
    interface onItemClicklistener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClicklistener(listener:onItemClicklistener)
    {
        mlistener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recyclelist_item,parent,false)
        return Myviewholder(itemView,mlistener)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val current=newslist[position]
        holder.titleimageview.setImageResource(current.titleImage)
        holder.tHeading.text=current.heading
    }

    override fun getItemCount(): Int {
        return newslist.size
    }
    class Myviewholder(itemview:View,listener:onItemClicklistener) :RecyclerView.ViewHolder(itemview){
        val titleimageview:ShapeableImageView=itemview.findViewById(R.id.title_image)
        val tHeading:TextView=itemview.findViewById(R.id.item_text)
        init {
            itemview.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}