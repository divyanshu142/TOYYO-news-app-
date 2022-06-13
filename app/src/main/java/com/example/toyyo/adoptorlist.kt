package com.example.toyyo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adoptorlist( private val listner: clickviewholder): RecyclerView.Adapter<adoptorlist.viewholdr>() {

    private val itam: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholdr {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.leyoutdisign, parent, false)
        val vewholder = viewholdr(view)
        view.setOnClickListener{
            listner.onclickviewholder(itam[vewholder.adapterPosition])
        }
        return vewholder
    }

    override fun onBindViewHolder(holder: viewholdr, position: Int) {
        val currentitem = itam[position]
        holder.itemviews.text = currentitem.tital
        holder.author.text = currentitem.author
        Glide.with(holder.itemView.context).load(currentitem.imagesurl).into(holder.images)
    }

    override fun getItemCount(): Int {
        return itam.size
    }

    fun updatadnews(updatatadenes: ArrayList<News>) {
        itam.clear()
        itam.addAll(updatatadenes)

        notifyDataSetChanged()
    }

    class viewholdr(itemView: View): RecyclerView.ViewHolder(itemView){

        val itemviews: TextView = itemView.findViewById(R.id.tital)
        val images : ImageView =  itemView.findViewById(R.id.image)
        val author: TextView = itemView.findViewById(R.id.author)
    }
    interface clickviewholder{

        fun onclickviewholder(item: News)
    }
}
