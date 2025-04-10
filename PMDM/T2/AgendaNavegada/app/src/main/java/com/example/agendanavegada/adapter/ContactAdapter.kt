package com.example.agendanavegada.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.agendanavegada.R
import com.example.agendanavegada.model.UserJSON
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ContactAdapter(var contexto: Context): RecyclerView.Adapter<ContactAdapter.MyHolder>() {

    lateinit var lista: ArrayList<UserJSON?>
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    inner class MyHolder(item: View): RecyclerView.ViewHolder(item){
        val boton: Button = item.findViewById(R.id.btnRecycler)
        val imagen: ImageView = item.findViewById(R.id.imagenRecycler)
        val texto: TextView = item.findViewById(R.id.textoRecycler)
    }

    init {
        lista = ArrayList()
        database = FirebaseDatabase.getInstance("https://productosapp-1b4c6-default-rtdb.europe-west1.firebasedatabase.app/")
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val userJSON: UserJSON? = lista[position]
        holder.texto.text = userJSON!!.firstName + " "+ userJSON.lastName
        Glide.with(contexto).load(userJSON.image).into(holder.imagen)
        holder.boton.setOnClickListener {
            // guardar en base de datos
            database.reference.child("usuarios")
                .child(auth.currentUser!!.uid)
                .child("favs")
                .child(userJSON.id.toString())
                .setValue(userJSON)
        }
    }

    fun addContact(x:UserJSON?){
        this.lista.add(x)
        notifyItemInserted(this.lista.size-1)
    }


}