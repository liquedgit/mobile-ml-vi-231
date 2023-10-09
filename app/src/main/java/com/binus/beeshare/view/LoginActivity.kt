package com.binus.beeshare.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.binus.beeshare.databinding.ActivityLoginBinding
import com.binus.beeshare.viemodel.LoginState
import com.binus.beeshare.viemodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        viewModel.loginState.observe(this, Observer { state ->
            when(state){
                is LoginState.Loading ->{

                }
                is LoginState.Success->{

                }
                is LoginState.Error->{

                }
            }
        })





    }
}