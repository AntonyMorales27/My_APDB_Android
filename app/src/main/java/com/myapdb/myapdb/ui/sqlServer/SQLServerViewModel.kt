package com.myapdb.myapdb.ui.sqlServer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SQLServerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is SQLServer Fragment En Constructions"
    }
    val text: LiveData<String> = _text

    private val _textb = MutableLiveData<String>().apply {
        value = "SQL SERVER ES EL IDE MAS UTILIZADO PARA DISEÑAR BASE DE DATOS"
    }
    val  textb: LiveData<String> = _textb
}