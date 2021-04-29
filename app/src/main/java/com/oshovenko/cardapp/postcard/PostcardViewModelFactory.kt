package com.oshovenko.cardapp.postcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource
import com.oshovenko.cardapp.main.MainModel

class PostcardViewModelFactory(
    private val model: MainModel,
    private val imageSource: AssetsImageSource,
    private val backgroundSource: AssetsImageSource,
    private val presetSource: AssetsImageSource
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostcardViewModel::class.java)) {
            return PostcardViewModel(model, imageSource, backgroundSource, presetSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}