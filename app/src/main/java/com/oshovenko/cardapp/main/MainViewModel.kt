package com.oshovenko.cardapp.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.oshovenko.cardapp.commons.Uroboros
import com.oshovenko.cardapp.events.SingleLiveEvent
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource
import com.oshovenko.cardapp.preset.Preset


class MainViewModel(
    val imageSource: AssetsImageSource,
    var backgroundSource: AssetsImageSource,
    val presetSource: AssetsImageSource
) : ViewModel() {

    private val _navigationLiveEvent = SingleLiveEvent<NavDirections>()
    val navigationLiveEvent: LiveData<NavDirections> = _navigationLiveEvent

    val model = MainModel()
    private val preset = Preset()

    private val imagesIterator = Uroboros(imageSource.list(), imageSource.list().first())
    private val backgroundsIterator =
            Uroboros(backgroundSource.list(), backgroundSource.list().first())
    private val presetIterator = Uroboros(presetSource.list(), presetSource.list().first())
    private val presetTitleIterator = Uroboros(preset.presetTitle, preset.presetTitle.first())
    private val presetTextIterator = Uroboros(preset.presetText, preset.presetText.first())

    private val _errorName = MutableLiveData<Boolean>()
    val errorName: LiveData<Boolean> = _errorName

    private val _errorTitle = MutableLiveData<Boolean>()
    val errorTitle: LiveData<Boolean> = _errorTitle

    private val _errorText = MutableLiveData<Boolean>()
    val errorText: LiveData<Boolean> = _errorText

    init {
        model.imageBackground = backgroundSource.getDrawable(backgroundsIterator.get())
        model.imageFace = imageSource.getDrawable(imagesIterator.get())
        model.presetImage = presetSource.getDrawable(presetIterator.get())
        model.presetTitle = presetTitleIterator.get()
        model.presetText = presetTextIterator.get()
    }

    fun showPostcardFragment() {
        model.apply {
            _errorName.value = name.isEmpty()
            _errorTitle.value = title.isEmpty()
            _errorText.value = text.isEmpty()
            if (!isError()) {
                _navigationLiveEvent.value =
                        MainFragmentDirections.actionMainFragmentToPostcardFragment(model)
            }
        }
    }

    fun getAvatar(){

    }

    fun setupPresetValue(){
        model.title = presetTitleIterator.get()
        model.text = presetTextIterator.get()
        model.imageBackground = presetSource.getDrawable(presetIterator.get())
    }

    fun getNextImage() {
        model.imageFace = imageSource.getDrawable(imagesIterator.next().get())
    }

    fun getPreviousImage() {
        model.imageFace = imageSource.getDrawable(imagesIterator.prev().get())
    }

    fun getNextBackground() {
        model.imageBackground = backgroundSource.getDrawable(backgroundsIterator.next().get())
    }

    fun getNextPreset() {
        model.presetImage = presetSource.getDrawable(presetIterator.next().get())
        model.presetTitle = presetTitleIterator.next().get()
        model.presetText = presetTextIterator.next().get()
    }

    fun getPreviousPreset() {
        model.presetImage = presetSource.getDrawable(presetIterator.prev().get())
        model.presetTitle = presetTitleIterator.prev().get()
        model.presetText = presetTextIterator.prev().get()
    }
}