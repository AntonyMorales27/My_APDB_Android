package com.myapdb.myapdb.ui.dominio.dominio.repository

interface AuthRepository {

        suspend fun login (email: String, password:String): String
        suspend fun SingUp (email: String, password: String): String


    }
