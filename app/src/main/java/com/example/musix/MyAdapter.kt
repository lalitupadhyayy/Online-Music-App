package com.example.musix

import android.app.Activity
import android.media.MediaPlayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create the view in case the layout manager fails to create view for data
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_iten,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //populate data into the view
        val currentData = dataList[position]
        val mediaPlayer = MediaPlayer.create(context,currentData.preview.toUri())
        holder.title.text = currentData.title
        
        holder.title.text = currentData.title

        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(holder.image);

        holder.play.setOnClickListener{
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener{
            mediaPlayer.stop()
        }
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val title: TextView
        val play: ImageButton
        val pause: ImageButton

        init {
            image = itemView.findViewById(R.id.songImage)
            title = itemView.findViewById(R.id.songTitle)
            play = itemView.findViewById(R.id.playbtn)
            pause = itemView.findViewById(R.id.pausebtn)
        }
    }
}