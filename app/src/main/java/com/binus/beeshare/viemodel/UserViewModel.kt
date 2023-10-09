package com.binus.beeshare.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binus.beeshare.model.AuthRepository

class UserViewModel : ViewModel() {
    private val _userState = MutableLiveData<UserState>()
    val userState : LiveData<UserState> = _userState
    private val authRepo : AuthRepository = AuthRepository()

    fun checkUserState(){
        if(authRepo.checkUser() != null){
            _userState.value = UserState.LoggedIn
        }else{
            _userState.value = UserState.NotLoggedIn
        }
    }

}

sealed class UserState{
    object LoggedIn : UserState()
    object NotLoggedIn : UserState()
}