package com.jordichorro.appbanco

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jordichorro.appbanco.databinding.CambiarClaveActivityBinding

class CambiarClaveActivity : AppCompatActivity() {
    private lateinit var binding: CambiarClaveActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CambiarClaveActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGuardarCambio.setOnClickListener {
            val contrasenaNueva = binding.etNuevaPassword.editableText?.toString()
            val contrasenaConfirmar = binding.etConfirmarPassword.editableText?.toString()


            if (contrasenaNueva == contrasenaConfirmar) {
                Toast.makeText(this, "CONTRASEÑA CAMBIADA EXITOSAMENTE", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show()
            }
        }
    }
}