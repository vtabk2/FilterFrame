package com.core.filterframe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.core.filterframe.databinding.ItemFrameRatioBinding
import com.core.filterframe.model.RatioFilter

class FrameRatioAdapter(context: Context, private val ratioList: List<RatioFilter>, val callback: (ratioFilter: RatioFilter) -> Unit) : RecyclerView.Adapter<FrameRatioAdapter.RatioHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatioHolder {
        return RatioHolder(ItemFrameRatioBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: RatioHolder, position: Int) {
        val ratioFilter = ratioList[position]
        holder.imageRatio.setImageResource(ratioFilter.resId)
        //
        holder.tvRatio.text = ratioFilter.name

        holder.clRoot.isSelected = ratioFilter.isSelected

        holder.clRoot.setOnClickListener {
            ratioFilter.isSelected = !ratioFilter.isSelected
            callback.invoke(ratioFilter)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return ratioList.size
    }

    inner class RatioHolder(itemFrameRatioBinding: ItemFrameRatioBinding) : RecyclerView.ViewHolder(itemFrameRatioBinding.root) {
        val clRoot = itemFrameRatioBinding.clRoot
        val tvRatio = itemFrameRatioBinding.tvRatio
        val imageRatio = itemFrameRatioBinding.imageRatio
    }
}