package com.example.aplicacion_mapa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.menu)

        val botonInicio = findViewById<MaterialButton>(R.id.botonInicio)
        val botonCreditos = findViewById<MaterialButton>(R.id.botonCreditos)

        botonInicio.setOnClickListener {

            val ventanaLugares = Intent(this, Lugares::class.java)

            startActivity(ventanaLugares)
        }

        botonCreditos.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.textoCreditos)
                .setMessage(R.string.textoDesarrollador)
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }
}