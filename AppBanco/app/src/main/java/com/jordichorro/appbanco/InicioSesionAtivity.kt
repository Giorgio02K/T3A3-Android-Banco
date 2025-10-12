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

        val loginButton = findViewById<Button>(R.id.login_button)
        val usuario = findViewById<TextInputLayout>(R.id.user_login)
        val password = findViewById<TextInputLayout>(R.id.password_login)
        val salir = findViewById<Button>(R.id.salir_button)
        salir.setOnClickListener {
            finish()
        }
        loginButton.setOnClickListener {
            val userText = usuario.editText?.text.toString()
            val passwordText = password.editText?.text.toString()
            if (userText == "admin" && passwordText == "admin") {
                val intent = Intent(this, BienvenidaActivity::class.java)
                intent.putExtra("usuario", userText)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }


    }


}