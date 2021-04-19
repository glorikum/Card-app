package com.oshovenko.cardapp.data

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oshovenko.cardapp.R

class PostcardViewModel() : ViewModel() {
    private val _title = MutableLiveData("Title")
    private val _name = MutableLiveData("Name")
    private val _text =  MutableLiveData("hdhbdhf dfhdjhfvhdf dfhvbdhfvnhdfv dfhvbdkfjmjdfv dfv")
    private val _avatar =  MutableLiveData(R.drawable.background_fire)
    private val _face =  MutableLiveData(R.drawable.fjb1)
    private val _background =  MutableLiveData(R.drawable.background_fire)

    val title: LiveData<String> = _title
    val name: LiveData<String> = _name
    val text: LiveData<String> = _text
    val avatar: LiveData<Int> = _avatar
    val face: LiveData<Int> = _face
    val background: LiveData<Int> = _background
}