package com.oshovenko.cardapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostcardViewModel(private val observableCard: ObservableCard){
    private  val _title = MutableLiveData(observableCard.title)
    private val _name = MutableLiveData(observableCard.name)
    private val _text =  MutableLiveData(observableCard.text)
    private val _avatar =  MutableLiveData(observableCard.avatar)
    private val _face =  MutableLiveData(observableCard.face)
    private val _background =  MutableLiveData(observableCard.background)

    val title: LiveData<String?> = _title
    val name: LiveData<String?> = _name
    val text: LiveData<String?> = _text
    val avatar: LiveData<Int> = _avatar
    val face: LiveData<String?> = _face
    val background: LiveData<String?> = _background
}