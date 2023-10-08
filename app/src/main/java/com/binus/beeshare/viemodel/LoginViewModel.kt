package com.binus.beeshare.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binus.beeshare.model.AuthRepository

class LoginViewModel: ViewModel() {
    private val authRepository : AuthRepository = AuthRepository()
    private val _loginState = MutableLiveData<LoginState>()
    val loginState :  LiveData<LoginState> = _loginState

    fun login(email : String, password : String){
        _loginState.value = LoginState.Loading
        authRepository.loginUser(email, password).addOnCompleteListener{task ->
            if(task.isSuccessful){
                _loginState.value = LoginState.Success
            }else{
                _loginState.value = LoginState.Error(task.exception?.message ?: "Unknown error")
            }

        }
    }

}

sealed class LoginState{
    object Loading : LoginState()
    object  Success : LoginState()
    data class Error(val message : String) : LoginState()
}