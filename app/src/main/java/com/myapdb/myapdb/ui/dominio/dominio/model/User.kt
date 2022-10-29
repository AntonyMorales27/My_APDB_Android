package com.myapdb.myapdb.ui.dominio.dominio.model


import java.util.UUID.*

data class User (
    val uid: String = randomUUID().toString(),
    val email: String = "",
    val name: String = "",
    val lastName: String = "",
    val userName: String = "",
)