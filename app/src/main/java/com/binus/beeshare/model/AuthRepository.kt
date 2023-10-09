package com.binus.beeshare.model

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository {
    private val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    fun loginUser(email : String, password : String) : Task<AuthResult>{
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    fun signupUser(email : String, password: String) : Task<AuthResult>{
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    fun checkUser() : FirebaseUser?{
        return firebaseAuth.currentUser
    }

    

}