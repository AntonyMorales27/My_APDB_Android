package com.myapdb.myapdb.ui.dominio.dominio.usercase

import com.myapdb.myapdb.Resource
import com.myapdb.myapdb.ui.dominio.dominio.model.User
import com.myapdb.myapdb.ui.dominio.dominio.repository.AuthRepository
import com.myapdb.myapdb.ui.dominio.dominio.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FirebaseSinUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val uidRegistered = authRepository.SingUp(user.email, password)

        var isDBRegisteredSuccessfully = false

        if (uidRegistered.isNotEmpty()){
            isDBRegisteredSuccessfully = userRepository.createUser(user.copy(uid = uidRegistered))
        }

        if (isDBRegisteredSuccessfully) {
            emit(Resource.Success(true))
        } else {
            emit(Resource.Error("Sign up error"))
        }
    }
}