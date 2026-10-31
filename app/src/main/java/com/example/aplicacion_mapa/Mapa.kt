package com.example.aplicacion_mapa

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Mapa : AppCompatActivity(), OnMapReadyCallback {

    private var nombre = ""
    private var latitud = 0.0
    private var longitud = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.mapa)

        nombre = intent.getStringExtra("nombre") ?: getString(R.string.lugar1)
        latitud = intent.getDoubleExtra("latitud", 40.6892)
        longitud = intent.getDoubleExtra("longitud", -74.0445)

        val textoTitulo = findViewById<TextView>(R.id.textoTituloMapa)

        textoTitulo.text = nombre

        val fragmentoMapa = supportFragmentManager
            .findFragmentById(R.id.mapaGoogle) as SupportMapFragment

        fragmentoMapa.getMapAsync(this)

        val botonRegresar = findViewById<Button>(R.id.botonRegresarMapa)

        botonRegresar.setOnClickListener {
            finish()
        }
    }

    override fun onMapReady(mapaGoogle: GoogleMap) {

        val ubicacion = LatLng(latitud, longitud)

        mapaGoogle.addMarker(
            MarkerOptions()
                .position(ubicacion)
                .title(nombre)
                .icon(crearIconoMarcador())
        )

        mapaGoogle.moveCamera(
            CameraUpdateFactory.newLatLngZoom(ubicacion, 15f)
        )
    }

    private fun crearIconoMarcador(): BitmapDescriptor {

        val dibujo = requireNotNull(
            ContextCompat.getDrawable(this, R.drawable.icono_marcador)
        )

        val imagen = Bitmap.createBitmap(
            dibujo.intrinsicWidth,
            dibujo.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )

        val lienzo = Canvas(imagen)

        dibujo.setBounds(0, 0, lienzo.width, lienzo.height)

        dibujo.draw(lienzo)

        return BitmapDescriptorFactory.fromBitmap(imagen)
    }
}