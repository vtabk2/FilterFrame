package com.core.filterframe

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.core.filterframe.databinding.FrameFilterViewBinding
import com.core.filterframe.adapter.FrameRatioAdapter
import com.core.filterframe.adapter.NumberOfPhotosAdapter
import com.core.filterframe.model.FrameFilter
import com.core.filterframe.model.NumberOfPhotos
import com.core.filterframe.model.RatioFilter

class FrameFilterView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ConstraintLayout(context, attrs), LifecycleOwner {
    private var binding: FrameFilterViewBinding = FrameFilterViewBinding.inflate(LayoutInflater.from(context), this, true)
    private var numberOfPhotosAdapter: NumberOfPhotosAdapter? = null
    private var frameRatioAdapter: FrameRatioAdapter? = null

    private var frameFilter = FrameFilter()

    private val lifecycleRegistry = LifecycleRegistry(this)

    var onFrameFilterListener: OnFrameFilterListener? = null

    init {
        val list = mutableListOf<NumberOfPhotos>().apply {
            add(NumberOfPhotos(1))
            add(NumberOfPhotos(2))
            add(NumberOfPhotos(3))
            add(NumberOfPhotos(4))
            add(NumberOfPhotos(5))
            add(NumberOfPhotos(6))
        }

        val rList = mutableListOf<RatioFilter>().apply {
            add(RatioFilter(name = "1:1", ratio = 1f, resId = R.drawable.selector_ratio_frame_1_1))
            add(RatioFilter(name = "2:3", ratio = 2f / 3, resId = R.drawable.selector_ratio_frame_2_3))
            add(RatioFilter(name = "3:4", ratio = 3f / 4, resId = R.drawable.selector_ratio_frame_3_4))
            add(RatioFilter(name = "9:16", ratio = 9f / 16, resId = R.drawable.selector_ratio_frame_9_16))
            add(RatioFilter(name = "16:9", ratio = 16f / 9, resId = R.drawable.selector_ratio_frame_16_9))
            add(RatioFilter(name = context.getString(R.string.text_others), ratio = -1f, resId = R.drawable.selector_ratio_frame_other))
        }

        frameFilter.ratioList.addAll(rList.toMutableList())

        numberOfPhotosAdapter = NumberOfPhotosAdapter(context, list, callback = { number ->
            if (number.isSelected) {
                frameFilter.numberList.add(number.number)
            } else {
                frameFilter.numberList.remove(number.number)
            }
            onFrameFilterListener?.onFilter(frameFilter)
        })

        binding.rvNumberOfPhotos.adapter = numberOfPhotosAdapter

        frameRatioAdapter = FrameRatioAdapter(context, rList, callback = { ratioFilter ->
            frameFilter.ratioList.find { it.ratio == ratioFilter.ratio }?.isSelected = ratioFilter.isSelected
            onFrameFilterListener?.onFilter(frameFilter)
        })

        binding.rvRatio.adapter = frameRatioAdapter

        binding.imageFrameFilterClose.setOnClickListener {
            close()
        }
        setOnClickListener {
            // nothing
        }
        elevation = 12f
    }

    fun close() {
        onFrameFilterListener?.onDone()
    }

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    interface OnFrameFilterListener {
        fun onDone()
        fun onFilter(frameFilter: FrameFilter)
    }
}