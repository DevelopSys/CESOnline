package com.example.agenda

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.databinding.ActivityMainBinding
import com.example.agenda.dataset.Dataset
import com.example.agenda.ui.activity.RegisterActivity
import com.example.agenda.ui.activity.HomeActivity
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
                val intent: Intent = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(intent)
            }

            binding.botonLogin.id -> {
                // campos de texto, rellenos?
                if (binding.editPass.text.isNotEmpty() && binding.editNombre.text.isNotEmpty()) {
                    // buscar en la base dato admin@gmail.com 1234
                    val correoUsuario = binding.editNombre.text.toString()
                    val passUsuario = binding.editPass.text.toString()
                    /*if (binding.editPass.text.toString()
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
                    }*/
                    val usuarioLogin = Dataset.comprobarLogin(correoUsuario, passUsuario)
                    if (usuarioLogin != null) {
                        val intent: Intent = Intent(applicationContext, HomeActivity::class.java);
                        intent.putExtra(
                            "usuario",
                            usuarioLogin
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

    override fun onRestart() {
        super.onRestart()
        binding.editPass.text.clear()
        binding.editNombre.text.clear()
        binding.checkRecordar.isChecked = false
    }
}