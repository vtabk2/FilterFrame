package com.core.filterframe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.filterframe.databinding.ItemNumberOfPhotosBinding
import com.core.filterframe.model.NumberOfPhotos

class NumberOfPhotosAdapter(var context: Context, var itemList: MutableList<NumberOfPhotos>, val callback: (item: NumberOfPhotos) -> Unit) : RecyclerView.Adapter<NumberOfPhotosAdapter.NumberOfPhotosViewHolder>() {
    private var layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberOfPhotosViewHolder {
        return NumberOfPhotosViewHolder(ItemNumberOfPhotosBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: NumberOfPhotosViewHolder, position: Int) {
        val item = itemList[position]
        if (item.number >= 6) {
            holder.tvNumberOfPhotos.text = "${item.number}+"
        } else {
            holder.tvNumberOfPhotos.text = item.number.toString()
        }

        holder.tvNumberOfPhotos.isSelected = item.isSelected

        holder.tvNumberOfPhotos.setOnClickListener {
            item.isSelected = !item.isSelected
            callback.invoke(item)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class NumberOfPhotosViewHolder(itemNumberOfPhotosBinding: ItemNumberOfPhotosBinding) : RecyclerView.ViewHolder(itemNumberOfPhotosBinding.root) {
        val tvNumberOfPhotos = itemNumberOfPhotosBinding.tvNumberOfPhotos
    }
}