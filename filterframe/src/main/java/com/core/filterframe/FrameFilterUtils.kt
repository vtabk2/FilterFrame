package com.core.filterframe

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import com.core.filterframe.databinding.DialogFrameCategoryBinding
import com.core.filterframe.taglayout.TagView

object FrameFilterUtils {
    fun initFrameCategoryDialog(context: Context, index: Int, categoryList: MutableList<String>, callback: (position: Int) -> Unit): Dialog {
        val frameCategoryDialog = Dialog(context)
        val binding = DialogFrameCategoryBinding.inflate(LayoutInflater.from(context), null, false)
        frameCategoryDialog.setContentView(binding.root)
        frameCategoryDialog.setCancelable(true)
        binding.tvFrameCategory.text = String.format("%s (%d)", context.getString(R.string.text_category), categoryList.size)
        categoryList.forEach { frameCategory ->
            binding.tagLayout.addTag(frameCategory)
        }
        binding.tagLayout.setCheckTag(index)

        frameCategoryDialog.setCancelable(true)
        frameCategoryDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.imageFrameClose.setOnClickListener {
            frameCategoryDialog.dismiss()
        }

        binding.tagLayout.tagCheckListener = TagView.OnTagCheckListener { position, _, isChecked ->
            if (isChecked) {
                callback.invoke(position)
            }
            frameCategoryDialog.dismiss()
        }

        //Grab the window of the dialog, and change the width
        val lp = WindowManager.LayoutParams()
        frameCategoryDialog.window?.let {
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            lp.copyFrom(it.attributes)

            //This makes the dialog take up the full width
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT

            lp.gravity = Gravity.BOTTOM
            it.attributes = lp
        }
        return frameCategoryDialog
    }
}