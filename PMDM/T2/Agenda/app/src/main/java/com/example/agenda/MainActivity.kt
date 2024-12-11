package com.example.agenda

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.agenda.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLogin.setOnClickListener(this)
        binding.botonRegistro.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.botonRegistro.id -> {

            }

            binding.botonLogin.id -> {
                // campos de texto, rellenos?
                if (binding.editPass.text.isNotEmpty() && binding.editNombre.text.isNotEmpty()) {
                    // buscar en la base dato admin@gmail.com 1234
                    if (binding.editPass.text.toString()
                            .equals("1234") && binding.editNombre.text.toString()
                            .equals("admin@gmail.com", true)
                    ) {
                        // Intents -> acciones
                        // origen de la comunicacion
                        val intent: Intent = Intent(applicationContext, SecondActivity::class.java);
                        intent.putExtra(
                            "usuario",
                            Usuario(
                                binding.editNombre.text.toString(),
                                binding.editPass.text.toString()
                            )
                        )

                        startActivity(intent)
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Fallo de credenciales",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Snackbar.make(
                        binding.root,
                        "Por favor rellena los datos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}