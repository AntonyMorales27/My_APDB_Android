package com.myapdb.myapdb.ui.mongoDB

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MongoDBViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is MongoDB Fragment En Constructions 3.0"
    }
    val text: LiveData<String> = _text
}