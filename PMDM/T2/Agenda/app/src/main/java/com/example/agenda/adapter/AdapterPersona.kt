package com.example.agenda.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda.R
import com.example.agenda.model.Usuario

class AdapterPersona (var lista: ArrayList<Usuario>
, var context: Context)
    : RecyclerView.Adapter<AdapterPersona.MyHolder>() {

    inner class MyHolder (item:View) : RecyclerView.ViewHolder(item){
        // es el template que forma el XML -> solo se crea 1 vez
        val imagen: ImageView = item.findViewById(R.id.imagenFila)
        val nombre: TextView = item.findViewById(R.id.nombreFila)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // instanciar la plantilla
        // XML -> view
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_recycler
            ,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantas filas se van a pintar
        return lista.size;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asociar template con los datos
        val usuario = lista[position]
        holder.nombre.text = usuario.nombre
        holder.imagen.setOnClickListener {
            Log.v("pulsado","El elemento pulsado es ${usuario.pass}")
        }
    }

}