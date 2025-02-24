package com.example.agendanavegada.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agendanavegada.R
import com.example.agendanavegada.databinding.FragmentRegistroBinding

class RegitroFragment: Fragment() {

    private lateinit var binding: FragmentRegistroBinding

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
            findNavController().navigate(R.id.action_regitroFragment_to_loginFragment)
        }
    }
}