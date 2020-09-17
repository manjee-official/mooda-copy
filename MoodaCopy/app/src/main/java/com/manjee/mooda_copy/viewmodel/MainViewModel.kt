package com.manjee.mooda_copy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _toggleFab: MutableLiveData<Void> = MutableLiveData()
    val toggleFab: LiveData<Void> get() = _toggleFab
    private val _selectEmotion: MutableLiveData<String> = MutableLiveData()
    val selectEmotion: LiveData<String> = _selectEmotion

    fun clickFab() {
        _toggleFab.value = null
    }

    fun setSelectEmotion(emotion: String) {
        _selectEmotion.value = emotion
    }
}