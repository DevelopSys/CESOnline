package com.example.agendanavegada.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendanavegada.R
import com.example.agendanavegada.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://productosapp-1b4c6-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // retorno la inflada del fragment R.layout.fragement_login
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.v("usuario", auth.currentUser?.uid?:"no hay nadie iniciado")
        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regitroFragment)
        }
        binding.botonLogin.setOnClickListener {

            // escribir en la base de datos

            /*database.reference.child("aplicacion")
                .child("responsable").setValue("Borja Martin")*/

            auth.signInWithEmailAndPassword(
                binding.editNombre.text.toString(), binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)

                } else {
                    Snackbar.make(
                        binding.root,
                        "Fallo en el inicio", Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            /*if (binding.editNombre.text.toString().equals("borja@gmail.com") && binding.editPass.text.toString().equals("1234")){
            } else {

            }*/
        }
    }
}