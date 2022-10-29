package com.myapdb.myapdb.ui.mySQL

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MySQLViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is MYSQL Fragment En Constructions 2.0"
    }
    val text: LiveData<String> = _text
}