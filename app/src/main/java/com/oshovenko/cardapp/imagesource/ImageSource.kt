package com.oshovenko.cardapp.imagesource

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface ImageSource {

    fun getBitmap(name: String): Bitmap

    fun list(): List<String>

    fun getDrawable(name: String): Drawable
}
