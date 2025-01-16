package com.example.agenda.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.agenda.R
import com.example.agenda.databinding.ActivityRegisterBinding
import com.example.agenda.dataset.Dataset
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonRegistro.setOnClickListener {
            if (binding.editPass.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()) {
                val perfil = binding.spinnerPerfiles.selectedItem.toString()
                val correo = binding.editCorreo.text.toString()
                val pass = binding.editPass.text.toString()
                if (perfil.equals("Administrador") && binding.editVerificacion.text.toString()
                        .equals("superpass")
                ) {

                    Dataset.insertarUsuario(correo, pass, perfil)
                    finish()
                } else if (perfil.equals("Usuario")) {
                    Dataset.insertarUsuario(correo, pass, perfil)
                    finish()
                } else {
                    Snackbar.make(binding.root, "Fallo de registro", Snackbar.LENGTH_SHORT).show()
                }
                // Log.v("prueba", "Los datos son $perfil $pass $correo")


            } else {
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            }
        }
        binding.spinnerPerfiles.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val perfil = binding.spinnerPerfiles.selectedItem
                    if (perfil.equals("Administrador")) {
                        binding.editVerificacion.visibility = View.VISIBLE
                    } else {
                        binding.editVerificacion.visibility = View.GONE
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }

    }
}