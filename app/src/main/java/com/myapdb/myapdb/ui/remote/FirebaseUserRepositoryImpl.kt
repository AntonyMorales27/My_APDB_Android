package com.myapdb.myapdb.ui.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.myapdb.myapdb.ui.dominio.dominio.model.User
import com.myapdb.myapdb.ui.dominio.dominio.repository.UserRepository
import com.myapdb.myapdb.ui.remote.FirebaseConstants.USERS_COLLECTION
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class FirebaseUserRepositoryImpl @Inject constructor(

): UserRepository {

    override suspend fun createUser(user: User): Boolean {
        return try {
            var isSuccessful = false
            FirebaseFirestore.getInstance().collection(USERS_COLLECTION)
                .document(user.uid)
                .set(user, SetOptions.merge())
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()
            isSuccessful
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getUser(uid: String): User {
        return try {
            var loggedUser = User()
            FirebaseFirestore.getInstance().collection(USERS_COLLECTION)
                .document(uid)
                .get()
                .addOnSuccessListener {
                    loggedUser = it.toObject(User::class.java)!!
                }
                .await()
            loggedUser
        } catch (e: Exception) {
            User()
        }
    }
}