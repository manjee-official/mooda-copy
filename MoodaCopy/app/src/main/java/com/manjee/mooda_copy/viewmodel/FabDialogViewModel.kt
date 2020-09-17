package com.manjee.mooda_copy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manjee.mooda_copy.util.CommonUtil

class FabDialogViewModel : ViewModel() {

    private val _toggleFab: MutableLiveData<Void> = MutableLiveData()
    val toggleFab: LiveData<Void> get() = _toggleFab
    private val _clickEmotion: MutableLiveData<String> = MutableLiveData()
    val clickEmotion: LiveData<String> = _clickEmotion

    fun clickFab() {
        CommonUtil.printDebugLog("MainViewModel", "clickFab")
        _toggleFab.value = null
    }

    fun clickEmotion(emotion: String) {
        _clickEmotion.value = emotion
    }
}