package com.oshovenko.cardapp.until

import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter


object BindingAdapters {
    @BindingAdapter("srcCompat")
    fun ImageView.srcCompat(id: Int) {
        setImageResource(id)
    }

    @BindingAdapter("background")
    fun FrameLayout.background(id: Int) {
        setBackgroundResource(id)
    }
}