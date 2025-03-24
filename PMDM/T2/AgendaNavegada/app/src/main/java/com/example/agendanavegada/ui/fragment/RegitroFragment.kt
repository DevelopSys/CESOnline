package com.example.agendanavegada.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agenda.model.Usuario
import com.example.agendanavegada.R
import com.example.agendanavegada.databinding.FragmentRegistroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegitroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://productosapp-1b4c6-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonRegistro.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    guardarUsuario(
                        Usuario(
                            nombre = binding.editNombre.text.toString(),
                            correo = binding.editCorreo.text.toString(),
                            perfil = binding.spinnerPerfiles.selectedItem.toString()
                        )
                    )
                    notificacionUsuario()
                } else {
                    Snackbar.make(
                        binding.root,
                        "fallo en el registro",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            //
        }
        binding.botonVolver.setOnClickListener {
            findNavController().navigate(R.id.action_regitroFragment_to_loginFragment)
            // auth.signOut()

        }
    }

    fun notificacionUsuario() {
        Snackbar.make(
            binding.root,
            "usuario registrado correctamente",
            Snackbar.LENGTH_LONG
        ).setAction("Quiere iniciar sesion") {
            findNavController().navigate(R.id.action_regitroFragment_to_mainFragment)
        }.show()
    }

    fun guardarUsuario(usuario: Usuario) {
        val referencia = database.reference.child("usuarios").child(auth.currentUser!!.uid);
        referencia.setValue(usuario)
        //DELETE
        referencia.child("pass").setValue(null)
    }

}