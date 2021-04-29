package com.oshovenko.cardapp.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource

class MainViewModelFactory(private val imageSource: AssetsImageSource, private val backgroundSource: AssetsImageSource,
                           private val presetSource: AssetsImageSource) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(imageSource, backgroundSource, presetSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}