package com.sampam.authentication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class databaseAdapter(var list: MutableList<datalist>): RecyclerView.Adapter<databaseAdapter.itemviewholder>() {
    class itemviewholder(itemView:View):RecyclerView.ViewHolder(itemView){
        val key:TextView=itemView.findViewById(R.id.keytextview)
        val value:TextView=itemView.findViewById(R.id.valuetextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemviewholder {
        val itemview=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return itemviewholder(itemview)
    }

    override fun onBindViewHolder(holder: itemviewholder, position: Int) {
         holder.key.text=list[position].datakey
        holder.value.text=list[position].datavalue
    }

    override fun getItemCount(): Int {
        return list.size
    }
}