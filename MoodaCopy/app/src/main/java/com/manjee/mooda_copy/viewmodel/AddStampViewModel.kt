package com.manjee.mooda_copy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddStampViewModel(private val emotion: String) : ViewModel() {

    private val _isMatched = MutableLiveData<Boolean>()
    val isMatched : LiveData<Boolean> = _isMatched

    private val emotionList = arrayListOf<String>()

    init {
        emotionList.add("happy")
        emotionList.add("sad")
        emotionList.add("emotion")

        emotionList.forEach {
            if(it == emotion) {
                _isMatched.value = true
            }
        }
    }

    fun addStamp() {

    }

    private fun checkEmotionText() {

    }

    fun checkEmptyContent(content: String): Boolean {
        if (content.isNotEmpty()) {
            return true
        }
        return false
    }

    fun aaaa() {
        TODO("Not yet implemented")
    }

    @Suppress("UNCHECKED_CAST")
    class AddStampViewModelFactory(private val emotion: String) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(AddStampViewModel::class.java)) {
                AddStampViewModel(emotion) as T
            } else {
                throw IllegalArgumentException()
            }
        }
    }
}