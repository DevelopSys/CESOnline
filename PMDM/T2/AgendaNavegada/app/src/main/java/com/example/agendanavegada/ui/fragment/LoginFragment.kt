package com.example.agendanavegada.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendanavegada.R
import com.example.agendanavegada.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // retorno la inflada del fragment R.layout.fragement_login
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonLogin.setOnClickListener {
            if (binding.editNombre.text.toString().equals("borja@gmail.com") && binding.editPass.text.toString().equals("1234")){
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            } else {
                Snackbar.make(binding.root, "Usuario no encontrado, ¿Quieres registrar un usuario?", Snackbar.LENGTH_LONG)
                    .setAction("OK"){
                        findNavController().navigate(R.id.action_loginFragment_to_regitroFragment)
                    }
                    .setAnchorView(R.id.fab).show()
            }
        }
    }
}