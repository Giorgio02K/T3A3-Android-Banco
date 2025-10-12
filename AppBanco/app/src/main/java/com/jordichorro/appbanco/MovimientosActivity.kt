package com.jordichorro.appbanco
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.MovimientosActivityBinding

class MovimientosActivity : AppCompatActivity() {
    private lateinit var binding: MovimientosActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MovimientosActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}