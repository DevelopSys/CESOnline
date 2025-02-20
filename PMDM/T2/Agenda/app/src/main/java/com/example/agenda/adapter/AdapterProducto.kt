package com.example.agenda.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agenda.R
import com.example.agenda.model.Producto
import com.example.agenda.model.Usuario
import com.example.agenda.ui.activity.DetailActicity

class AdapterProducto(
    var lista: ArrayList<Producto>, var context: Context
) : RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    inner class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        // es el template que forma el XML -> solo se crea 1 vez
        val imagen: ImageView = item.findViewById(R.id.imagenFila)
        val nombre: TextView = item.findViewById(R.id.nombreFila)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // instanciar la plantilla
        // XML -> view
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.item_recycler, parent, false
        )
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantas filas se van a pintar
        return lista.size;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asociar template con los datos
        val producto = lista[position]
        holder.nombre.text = producto.title
        Glide.with(context).load(producto.thumbnail)
            .placeholder(R.drawable.product)
            .into(holder.imagen)
        holder.imagen.setOnClickListener {
            // Log.v("pulsado","El elemento pulsado es ${usuario.pass}")
            val intent: Intent = Intent(context, DetailActicity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            val bundle = Bundle()
            bundle.putSerializable("producto",producto)
            intent.putExtra("datos",bundle)
            context.startActivity(intent)
        }
    }

}