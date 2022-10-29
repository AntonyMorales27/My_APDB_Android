package com.myapdb.myapdb.ui.foro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForoViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is FORO Fragment En Constructions 5.0"
    }
    val text: LiveData<String> = _text
}