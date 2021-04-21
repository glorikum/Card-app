package com.oshovenko.cardapp.until

import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


object BindingAdapters {
    private val pathToBackground = "file:///android_asset/background/"
    private val pathToItem = "file:///android_asset/item/"

    @BindingAdapter("app:srcCompat")
    @JvmStatic fun setImage(view: ImageView, face: String) {
        Picasso.get()
                .load(pathToItem + face)
                .resize(200,200)
                .into(view)
    }

    @BindingAdapter("tools:src")
    @JvmStatic fun setBackground(view: ImageView, background: String) {
        Picasso.get()
                .load(pathToBackground + background)
                .into(view)
    }
}