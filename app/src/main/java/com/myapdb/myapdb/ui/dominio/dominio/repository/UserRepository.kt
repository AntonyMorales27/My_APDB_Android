package com.myapdb.myapdb.ui.dominio.dominio.repository

import com.myapdb.myapdb.ui.dominio.dominio.model.User


interface UserRepository {


    suspend fun createUser(user: User): Boolean

    suspend fun getUser(uid: String): User
}