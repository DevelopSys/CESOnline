package com.example.agenda.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    // onAttach

    // onCreateDialog
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Dialogo información")
        builder.setMessage("App realizada por Borja Martín Herrera para la asignatura de PMDM")
        builder.setNeutralButton("No sé"){ _, _ -> Log.v("botones","Pulsado neutral") }
        builder.setPositiveButton("OK"){ _, _ -> Log.v("botones","Pulsado positivo") }
        builder.setNegativeButton("NO"){ _, _ -> Log.v("botones","Pulsado negativo") }
        return builder.create()
    }

    // onDettach

}