package com.example.agenda.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.agenda.R
import com.example.agenda.databinding.DialogDatosBinding
import com.example.agenda.model.Usuario

class DataDialog : DialogFragment() {

    private lateinit var view: View
    private lateinit var binding: DialogDatosBinding
    private lateinit var listener: OnDataListener
    private lateinit var usuario: Usuario;
    companion object {
        // conjunto de cosas
        fun newInstance(x: Usuario): DataDialog {
            val dialogo = DataDialog();
            val bundle = Bundle()
            bundle.putSerializable("usuario",x)
            dialogo.arguments = bundle
            return dialogo
        }
    }

    /*
    onAttach
    onViewCreated
    onCreate
    onStart
    onResumen
     */

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // ejecuciones que no tengan que ver con lo grafico
        // view <-> XML
        usuario = this.arguments?.getSerializable("usuario") as Usuario
        binding = DialogDatosBinding.inflate(LayoutInflater.from(context))
        listener = context as OnDataListener
        //view = LayoutInflater.from(context).inflate(R.layout.dialog_datos,null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        // title - message - item - buttons
        // view
        builder.setView(binding.root)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        binding.tituloDialogo.text ="Por favor ${usuario.nombre}, actualiza tus datos"
        binding.botonActualizar.setOnClickListener {
            val apellido = binding.editApellido.text.toString();
            val telefono = binding.editTelefono.text.toString().toInt();
            val direccion = binding.editDireccion.text.toString();
            val perfil = binding.spinnerTratamiento.selectedItem.toString()
            listener.onDataSelected(apellido, telefono, direccion, perfil)
            dismiss()
        }
    }

    interface OnDataListener {
        fun onDataSelected(apellido: String, telefono: Int, direccion: String, perfil: String);
    }
}