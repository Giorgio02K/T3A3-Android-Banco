package com.jordichorro.appbanco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.TransferenciasActivityBinding

class Transferencias_Activity  : AppCompatActivity() {
    private lateinit var binding: TransferenciasActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransferenciasActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}