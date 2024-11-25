package com.example.holamundo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // asocia la parte grafica y la parte logica
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
    }

    // toda la logica de mi app: que pasa cuando pulso un boton, que pasa si selecciono
    // una cosa del spinner
}