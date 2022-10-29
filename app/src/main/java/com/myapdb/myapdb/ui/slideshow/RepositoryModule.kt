package com.myapdb.myapdb.ui.slideshow

import com.myapdb.myapdb.ui.dominio.dominio.repository.AuthRepository
import com.myapdb.myapdb.ui.dominio.dominio.repository.UserRepository
import com.myapdb.myapdb.ui.remote.FirebaseAuthRepositoryImpl
import com.myapdb.myapdb.ui.remote.FirebaseUserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(authRepository: FirebaseAuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindUserRepository(authRepository: FirebaseUserRepositoryImpl): UserRepository
}