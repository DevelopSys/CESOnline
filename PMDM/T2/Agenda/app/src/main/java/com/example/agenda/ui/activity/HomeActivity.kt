package com.example.agenda.ui.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley
import com.example.agenda.R
import com.example.agenda.adapter.AdapterPersona
import com.example.agenda.adapter.AdapterProducto
import com.example.agenda.databinding.ActivitySecondBinding
import com.example.agenda.dataset.DataSet
import com.example.agenda.model.Producto
import com.example.agenda.model.Usuario
import com.example.agenda.ui.dialog.DataDialog
import com.example.agenda.ui.dialog.DateDialog
import com.example.agenda.ui.dialog.InfoDialog
import com.example.agenda.ui.dialog.SubjectDialog
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class HomeActivity : AppCompatActivity(),
    InfoDialog.OnDialogoInfoListener,
    SubjectDialog.OnAsignaturasListener,
    DatePickerDialog.OnDateSetListener, DataDialog.OnDataListener {

    private lateinit var adapterPersona: AdapterPersona
    private lateinit var adapterProducto: AdapterProducto
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var binding: ActivitySecondBinding
    private lateinit var usuario: Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        // recuperar los datos que me pasan
        usuario = intent.getSerializableExtra("usuario") as Usuario
        supportActionBar?.title = "Home de ${usuario.nombre}"
        listaProductos = ArrayList()
        // adapterPersona = AdapterPersona(DataSet.lista, this)
        adapterProducto = AdapterProducto(listaProductos, this)
        // asocio recycler con adapter
        binding.recyclerUsuarios.adapter = adapterProducto
        // como se representan los datos
        /*binding.recyclerUsuarios.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,true)*/
        if (resources.configuration.orientation == 1) {
            binding.recyclerUsuarios.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, true
            )
        } else {
            binding.recyclerUsuarios.layoutManager =
                GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        }


        // linear - vertical
        // linear - horizontal
        // grid - horizontal
        // grid - vertical
        // staggered - vertical


        // binding.textoBienvenida.text = binding.textoBienvenida.text.toString() + " " + usuario.pass
        // depende del rol que tengas
        // admin
        // una lista de todos los usuarios que estan en la base de datos
        // usaurio
        // tus datos personales
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerUsuarios.setOnClickListener {
            Snackbar.make(binding.root, "Pulsado", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_cerrar -> {
                // finish()
                DataSet.lista.add(Usuario("nombre", "123123"))
                adapterPersona.notifyDataSetChanged()
            }

            R.id.menu_informacion -> {
                val dialogoInfo = InfoDialog()
                dialogoInfo.show(supportFragmentManager, null)
            }

            R.id.menu_datos -> {
                /*sacar cuadro de dialogo*/
                val dialogo: DataDialog = DataDialog.newInstance(usuario)
                dialogo.show(supportFragmentManager, null)

            }

            R.id.menu_accion1 -> {}
            R.id.menu_accion2 -> {}
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onRespuestaSeleted(respuesta: String) {
        if (respuesta.equals("si", true)) {
            val dialogoAsignaturas: SubjectDialog = SubjectDialog();
            dialogoAsignaturas.show(supportFragmentManager, null)
        } else {
            Snackbar.make(
                binding.root,
                "La respuesta obtenida es ${respuesta}, por lo que no continua el proceso",
                Snackbar.LENGTH_SHORT
            )
                .show()
        }

    }

    override fun onAsignaturasSelected(respuesta: ArrayList<String>) {
        Log.v("asignaturas", respuesta.toString())
        if (respuesta.size > 0) {
            val dialogoDate: DateDialog = DateDialog()
            dialogoDate.show(supportFragmentManager, null)
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Log.v("fecha", "La fecha seleccionada es ${p1}/${p2 + 1}/${p3}")
    }

    override fun onResume() {
        super.onResume()
        // 1. creo la peticion
        // 1. {}->JObject -> JObjectRequest
        // 1. []->JArray -> JArrayRequest
        // url
        // {} -> cuando hay exito
        // {} -> cuando hay fallo
        val peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products", {
            Snackbar.make(
                binding.root,
                "Todo OK",
                Snackbar.LENGTH_SHORT
            ).show()
            val products = it.getJSONArray("products")
            val gson = Gson()
            for (i in 0..products.length()-1){
                val productJSON = products.getJSONObject(i)
                val product = gson.fromJson(productJSON.toString(),Producto::class.java)
                // Log.v("datos",product.thumbnail.toString())
                listaProductos.add(product)
                adapterProducto.notifyDataSetChanged()
            }
        }, {
            Snackbar.make(
                binding.root,
                "Error en el procesamiento de la peticion",
                Snackbar.LENGTH_SHORT
            ).show()
        })
        // 2. lanzo la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onDataSelected(
        apellido: String,
        telefono: Int,
        direccion: String,
        perfil: String
    ) {
        Log.v("datos", apellido)
        Log.v("datos", telefono.toString())
        Log.v("datos", direccion)
        Log.v("datos", perfil)
    }


}