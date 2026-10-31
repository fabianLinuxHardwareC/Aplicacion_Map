package com.example.aplicacion_mapa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class Lugares : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.lugares)

        val botonRegresar = findViewById<Button>(R.id.botonRegresar)

        val tarjetaLugar1 = findViewById<MaterialCardView>(R.id.tarjetaLugar1)
        val tarjetaLugar2 = findViewById<MaterialCardView>(R.id.tarjetaLugar2)
        val tarjetaLugar3 = findViewById<MaterialCardView>(R.id.tarjetaLugar3)
        val tarjetaLugar4 = findViewById<MaterialCardView>(R.id.tarjetaLugar4)

        botonRegresar.setOnClickListener {
            finish()
        }

        tarjetaLugar1.setOnClickListener {
            abrirMapa(getString(R.string.lugar1), 40.6892, -74.0445)
        }

        tarjetaLugar2.setOnClickListener {
            abrirMapa(getString(R.string.lugar2), 37.8199, -122.4783)
        }

        tarjetaLugar3.setOnClickListener {
            abrirMapa(getString(R.string.lugar3), 38.89766, -77.03655)
        }

        tarjetaLugar4.setOnClickListener {
            abrirMapa(getString(R.string.lugar4), 34.00892, -118.49789)
        }
    }

    private fun abrirMapa(nombre: String, latitud: Double, longitud: Double) {

        val ventanaMapa = Intent(this, Mapa::class.java)

        ventanaMapa.putExtra("nombre", nombre)
        ventanaMapa.putExtra("latitud", latitud)
        ventanaMapa.putExtra("longitud", longitud)

        startActivity(ventanaMapa)
    }
}