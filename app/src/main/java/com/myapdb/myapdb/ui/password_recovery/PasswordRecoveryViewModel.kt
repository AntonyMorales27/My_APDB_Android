package com.myapdb.myapdb.ui.password_recovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapdb.myapdb.Resource
import com.myapdb.myapdb.ui.dominio.dominio.usercase.FirebasePasswordRecoveryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordRecoveryViewModel @Inject constructor(
    private val passwordRecoveryUseCase: FirebasePasswordRecoveryUseCase
): ViewModel() {

    private val _passwordSent: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val passwordSent: LiveData<Resource<Boolean>>
        get() = _passwordSent

    fun sendPasswordLink(email: String) {
        viewModelScope.launch {
            passwordRecoveryUseCase(email).onEach {
                _passwordSent.value = it
            }.launchIn(viewModelScope)
        }
    }

}