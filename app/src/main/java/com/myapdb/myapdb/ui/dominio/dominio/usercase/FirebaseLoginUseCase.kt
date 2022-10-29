package com.myapdb.myapdb.ui.dominio.dominio.usercase

import com.myapdb.myapdb.Resource
import com.myapdb.myapdb.ui.dominio.dominio.model.User
import com.myapdb.myapdb.ui.dominio.dominio.repository.AuthRepository
import com.myapdb.myapdb.ui.dominio.dominio.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)

        val loggedUserUid = authRepository.login(email, password)

        if (loggedUserUid.isNotEmpty()){

            val loggedUser = userRepository.getUser(loggedUserUid)
                LoggedUser.currentUser = loggedUser
            emit(Resource.Success(true))
            emit(Resource.Finished)
        } else{
            emit(Resource.Error("Login Error"))
            emit(Resource.Finished)
        }

    }
}