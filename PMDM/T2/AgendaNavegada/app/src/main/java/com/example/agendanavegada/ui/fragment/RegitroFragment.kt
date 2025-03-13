package com.example.agendanavegada.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendanavegada.R
import com.example.agendanavegada.databinding.FragmentRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegitroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
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
            )
            // findNavController().navigate(R.id.action_regitroFragment_to_loginFragment)
        }
    }
}