package com.oshovenko.cardapp.postcard

import androidx.lifecycle.ViewModel
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource
import com.oshovenko.cardapp.main.MainModel
import android.widget.ImageView as ImageView1

class PostcardViewModel(
    val model: MainModel,
    val imageSource: AssetsImageSource,
    val backgroundSource: AssetsImageSource,
    val presetSource: AssetsImageSource
) : ViewModel()