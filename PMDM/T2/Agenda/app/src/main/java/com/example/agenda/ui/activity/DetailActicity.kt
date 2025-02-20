package com.example.agenda.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.agenda.R
import com.example.agenda.databinding.ActivityDetailBinding
import com.example.agenda.model.Producto

class DetailActicity : AppCompatActivity() {

    // Producto
    private lateinit var producto: Producto

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        producto = intent.extras!!.getBundle("datos")!!.getSerializable("producto") as Producto
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this).load(producto.thumbnail).into(binding.imagenDetalle)
        binding.tituloDetalle.text = producto.title
        binding.descripcionDetalle.text = producto.description
    }
}