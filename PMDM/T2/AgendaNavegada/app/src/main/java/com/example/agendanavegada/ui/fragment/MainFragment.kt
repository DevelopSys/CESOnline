package com.example.agendanavegada.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda.model.Usuario
import com.example.agendanavegada.adapter.ContactAdapter
import com.example.agendanavegada.databinding.FragmentMainBinding
import com.example.agendanavegada.model.UserJSON
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.currentCoroutineContext

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null
    private lateinit var database: FirebaseDatabase
    private lateinit var adapter: ContactAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = ContactAdapter(context)
        auth = FirebaseAuth.getInstance();
        user = auth.currentUser!!
        // quien es el usuario autenticado -> recepcionando un objeto pasado
        database =
            FirebaseDatabase.getInstance("https://productosapp-1b4c6-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerUsuarios.adapter = adapter
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        database.reference.child("contactos")
            .child("users")
            .addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val usuario: UserJSON? = snapshot.getValue(UserJSON::class.java)
                    adapter.addContact(usuario)
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    TODO("Not yet implemented")
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    TODO("Not yet implemented")
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    TODO("Not yet implemented")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


        Log.v("test", user?.uid ?: "sin inicio de sesion")
        binding.btnConsultar.setOnClickListener {
            // query -> SELECT * FROM usuarios
            // obtener el valor de forma puntual
            // DataSnapshot
            // suscribirme a los cambios de un nodo
            // DataSnapshot cada vez que cambien
            database.reference.child("aplicacion")
                .child("nombre").addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        binding.nombreApp.text = snapshot.value.toString()
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
            /* database.reference.child("usuarios")
                 .addValueEventListener(object : ValueEventListener{
                 override fun onDataChange(snapshot: DataSnapshot) {
                     for (i in snapshot.children){
                         val usuario = i.getValue(Usuario::class.java)
                         Log.v("datos",usuario!!.correo.toString())
                     }
                 }

                 override fun onCancelled(error: DatabaseError) {
                     TODO("Not yet implemented")
                 }

             })*/

            database.reference.child("usuarios")
                .child(auth.currentUser!!.uid).child("favs")
                .addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                        // Log.v("datos", "Nodo añadido " + snapshot.toString())
                        val fav: UserJSON? = snapshot.getValue(UserJSON::class.java)
                        Log.v("datos", fav!!.firstName + " "+fav.lastName)
                    }

                    override fun onChildChanged(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                        Log.v("datos", "Nodo cambiado " + snapshot.toString())
                    }

                    override fun onChildRemoved(snapshot: DataSnapshot) {
                        Log.v("datos", "Nodo borrado " + snapshot.toString())
                    }

                    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                        Log.v("datos", "Nodo movido " + snapshot.toString())
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }


                })

            /* val query: Query = database.reference.child("usuarios")
                 .orderByChild("nombre").equalTo("Borja").limitToLast(2)*/

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        auth.signOut()
    }

}