package com.myapdb.myapdb.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.myapdb.myapdb.Menu2Activity
import com.myapdb.myapdb.R
import com.myapdb.myapdb.Resource
import com.myapdb.myapdb.databinding.ActivityMainBinding
import com.myapdb.myapdb.ui.password_recovery.RecuperarContrasenaActivity
import com.myapdb.myapdb.ui.signUp.RegistroActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.loginState.observe(this) { state ->
            when(state) {
                is Resource.Success -> {
                    navigateToDashboard()
                }
                is Resource.Error -> {
                    Toast.makeText(
                        this,
                        state.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Resource.Loading -> {  }
                else -> Unit
            }
        }
    }

    private fun initListeners() {

        binding.Registar.setOnClickListener {
            val Intent =  Intent(this, RegistroActivity::class.java)
            startActivity(Intent)
        }

        binding.OlvideContraseA.setOnClickListener {
            val Intent =  Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(Intent)
        }

        binding.Inicio.setOnClickListener {
            handleLogin()
        }

    }

    private fun handleLogin() {

        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextTextPassword.text.toString()

        viewModel.login(email, password)
    }

    private fun navigateToDashboard() {
        val Intent =  Intent(this, Menu2Activity::class.java)
        startActivity(Intent)
    }
}