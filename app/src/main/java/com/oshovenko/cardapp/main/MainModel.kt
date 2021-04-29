package com.oshovenko.cardapp.main

import android.graphics.drawable.Drawable
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.oshovenko.cardapp.BR
import com.oshovenko.cardapp.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MainModel(
    private var _name: String = "",
    private var _title: String = "",
    private var _text: String = "",
    private var _imageAva: @RawValue Drawable? = null,
    private var _imageBackground: @RawValue Drawable? = null,
    private var _imageFace: @RawValue Drawable? = null,
    private var _presetTitle: String = "",
    private var _presetText: String = "",
    private var _presetImage: @RawValue Drawable? = null
) : BaseObservable(), Parcelable {

    @get:Bindable
    var name: String = _name
        set(value) {
            _name = value
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var title: String = _title
        set(value) {
            _title = value
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    var text: String = _text
        set(value) {
            _text = value
            field = value
            notifyPropertyChanged(BR.text)
        }

    @get:Bindable
    var imageBackground: Drawable? = _imageBackground
        set(value) {
            _imageBackground = value
            field = value
            notifyPropertyChanged(BR.imageBackground)
        }

    @get:Bindable
    var imageAva: Drawable? = _imageAva
        set(value) {
            _imageAva = value
            field = value
            notifyPropertyChanged(BR.imageAva)
        }

    @get:Bindable
    var imageFace: Drawable? = _imageFace
        set(value) {
            _imageFace = value
            field = value
            notifyPropertyChanged(BR.imageFace)
        }

    @get:Bindable
    var presetTitle: String = _presetTitle
        set(value) {
            _presetTitle = value
            field = value
            notifyPropertyChanged(BR.presetTitle)
        }

    @get:Bindable
    var presetText: String = _presetText
        set(value) {
            _presetText = value
            field = value
            notifyPropertyChanged(BR.presetText)
        }

    @get:Bindable
    var presetImage: Drawable? = _presetImage
        set(value) {
            _presetImage = value
            field = value
            notifyPropertyChanged(BR.presetImage)
        }

    fun isError() =
        _name.isEmpty() || _title.isEmpty() || _text.isEmpty()
}