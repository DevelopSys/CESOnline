package com.example.agenda.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SubjectDialog : DialogFragment() {

    private var posicion: Int = -1
    private lateinit var respuesta: ArrayList<String>
    private lateinit var listener: OnAsignaturasListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnAsignaturasListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        respuesta = ArrayList()
        val opciones: Array<String> = arrayOf("PMDM", "DI", "AD", "SGE", "ING", "EIE")
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Por favor selecciona las asignaturas que quieres para la matricula")
        // message - items
        // builder.setItems(opciones, { _, i -> opciones[i] })
        /*builder.setSingleChoiceItems(opciones, -1, { _, i ->
            posicion = i;
        })*/
        builder.setMultiChoiceItems(opciones,null,{ _, i, b ->
            if (b){
                // meto
                respuesta.add(opciones[i])
            } else {
                // saco
                respuesta.remove(opciones[i])
            }
        })
        builder.setPositiveButton("Registrar", { _, _ ->
            // opciones[posicion]
            listener.onAsignaturasSelected(respuesta)
        })

        builder.setNeutralButton("Cancelar", { _, _ -> })

        return builder.create()
    }

    interface OnAsignaturasListener{
        fun onAsignaturasSelected(respuesta: ArrayList<String>)
    }

}