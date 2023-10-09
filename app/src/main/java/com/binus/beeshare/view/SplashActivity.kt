package com.binus.beeshare.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binus.beeshare.databinding.ActivitySplashBinding
import com.binus.beeshare.viemodel.UserState
import com.binus.beeshare.viemodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private lateinit var viewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        setContentView(binding.root)


        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.userState.observe(this) { userState ->
                when (userState) {
                    is UserState.LoggedIn -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    is UserState.NotLoggedIn -> {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)

                    }
                }
                finish()
            }
            viewModel.checkUserState()
        }, 2000)


    }

}