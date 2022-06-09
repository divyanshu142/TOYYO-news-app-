package com.example.toyyo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adoptorlist (private val itam: ArrayList<String>, private val listner: clickviewholder): RecyclerView.Adapter<adoptorlist.viewholdr>() {


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
        holder.itemviews.text = currentitem
    }

    override fun getItemCount(): Int {
        return itam.size
    }

    class viewholdr(itemView: View): RecyclerView.ViewHolder(itemView){

        val itemviews: TextView = itemView.findViewById(R.id.tital)
    }
    interface clickviewholder{
        fun onclickviewholder(item: String)
    }
}
