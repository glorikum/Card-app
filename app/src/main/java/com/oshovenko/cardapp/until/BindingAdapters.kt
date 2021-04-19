package com.oshovenko.cardapp.until

import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter


object BindingAdapters {
    @BindingAdapter("app:srcCompat")
    @JvmStatic fun setImage(view: ImageView, id: Int) {
        view.setImageResource(id)
    }

    @BindingAdapter("android:background")
    @JvmStatic fun setBackground(layout: FrameLayout, id: Int) {
        layout.setBackgroundResource(id)
    }
}