package com.example.agenda.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    // 2 Creo un objeto del tipo de la interfaz
    private lateinit var listener: OnDialogoInfoListener

    // onAttach
    // 3. Inicializo la interfaz
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // OnDialogoInfoListener = HomeActivity as OnDialogoInfoListener
        listener = context as OnDialogoInfoListener
    }

    // onCreateDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 4. Comunico
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Dialogo información")
        builder.setMessage("App realizada por Borja Martín Herrera para la asignatura de PMDM. ¿Quieres continuar con el registro de asignaturas?")
        builder.setNeutralButton("No sé"){ _, _ ->
            Log.v("botones","Pulsado neutral")
        }
        builder.setPositiveButton("OK"){ _, _ ->

            listener.onRespuestaSeleted("SI")
        }
        builder.setNegativeButton("NO"){ _, _ ->

            listener.onRespuestaSeleted("NO")
        }
        return builder.create()
    }

    // onDettach

    // 1 CREO UNA INTERFAZ
    interface OnDialogoInfoListener{
        fun onRespuestaSeleted(respuesta: String)
    }

}