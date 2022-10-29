package com.myapdb.myapdb.ui.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.myapdb.myapdb.Resource
import com.myapdb.myapdb.databinding.ActivityRegistroBinding
import com.myapdb.myapdb.ui.dominio.dominio.model.User
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    private val viewModel: SingUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObservers()
        initListener()
    }

    private fun initObservers() {
        viewModel.signUpState.observe(this){ state ->
            when(state){
                is Resource.Success -> {
                    finish()
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> {
                    Toast.makeText(this, "Error: ${state.message}", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Otra caso
                }
            }
        }
    }
    private fun initListener(){
        with(binding){
            singUpButton.setOnClickListener {
                handleSignUp()
            }
        }
    }

    private fun handleSignUp(){

        val user = User(
            email = binding.editTextTextEmailAddress.text.toString(),
            name = binding.editTextTextPersonName.text.toString(),
            lastName = binding.editTextTextLasName.text.toString(),
            userName = binding.editTextTextUserName.text.toString(),
        )

        val password = binding.editTextTextPassword.text.toString()

        viewModel.sinUp(user, password)
    }
}