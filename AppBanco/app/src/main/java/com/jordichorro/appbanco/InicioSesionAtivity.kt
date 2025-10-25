package com.jordichorro.appbanco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.jordichorro.appbanco.databinding.BienvenidaActivityBinding
import com.jordichorro.appbanco.databinding.InicioSesionActivityBinding

class InicioSesionAtivity : AppCompatActivity() {
    private lateinit var binding: InicioSesionActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = InicioSesionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.salirButton.setOnClickListener {
            finish()
        }

        binding.loginButton.setOnClickListener {
            val userText = binding.userLogin.editText?.text.toString()
            val passwordText = binding.passwordLogin.editText?.text.toString()
            if (userText == "" || passwordText == "") {
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                if (userText == "admin" && passwordText == "admin") {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("usuario", userText)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }


    }


}