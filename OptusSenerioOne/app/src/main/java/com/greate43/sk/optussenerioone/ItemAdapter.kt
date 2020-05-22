package com.greate43.sk.optussenerioone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var mData: List<String> = Collections.emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ItemViewHolder(view)
    }

    fun setData(data: List<String>) {
        mData = data
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.btn.text = mData[position]
        holder.btn.setOnClickListener {

        }
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btn = itemView.findViewById<Button>(R.id.btnItem)
    }

}