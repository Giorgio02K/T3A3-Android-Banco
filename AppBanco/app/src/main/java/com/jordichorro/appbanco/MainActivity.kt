package com.jordichorro.appbanco

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("usuario")
        binding.bienvenidoUsuario.text = "Bienvenido, $usuario"

        binding.cambiarContrasena.setOnClickListener {
            val intent = Intent(this, CambiarClaveActivity::class.java)
            startActivity(intent)
        }

        binding.salir.setOnClickListener {
            val intent = Intent(this, BienvenidaActivity::class.java)
            startActivity(intent)
        }

    }
}