package com.jordichorro.appbanco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.PosicionGlobalActivityBinding

class PosicionGlobalActivity : AppCompatActivity() {
    private lateinit var binding: PosicionGlobalActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PosicionGlobalActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}