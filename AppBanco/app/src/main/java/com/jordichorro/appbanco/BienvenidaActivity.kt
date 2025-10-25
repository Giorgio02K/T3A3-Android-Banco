package com.jordichorro.appbanco

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.BienvenidaActivityBinding


class BienvenidaActivity : AppCompatActivity() {
    private lateinit var binding : BienvenidaActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = BienvenidaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInicioWelcome.setOnClickListener {
            val intent = Intent(this, InicioSesionAtivity::class.java)
            startActivity(intent)
            true
        }

    }

}