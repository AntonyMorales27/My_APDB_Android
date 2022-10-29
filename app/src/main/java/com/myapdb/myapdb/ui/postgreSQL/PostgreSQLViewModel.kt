package com.myapdb.myapdb.ui.postgreSQL

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostgreSQLViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is POSTGRESQL Fragment En Constructions 4.0"
    }
    val text: LiveData<String> = _text
}