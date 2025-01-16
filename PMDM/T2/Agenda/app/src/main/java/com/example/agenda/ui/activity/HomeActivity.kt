package com.example.agenda.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda.R
import com.example.agenda.databinding.ActivitySecondBinding
import com.example.agenda.model.Usuario
import com.example.agenda.ui.dialog.InfoDialog

class HomeActivity : AppCompatActivity() {

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
        binding.textoBienvenida.text = binding.textoBienvenida.text.toString() + " " + usuario.pass

        // depende del rol que tengas
            // admin
                // una lista de todos los usuarios que estan en la base de datos
            // usaurio
                // tus datos personales

        R.id.menu_cerrar
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_cerrar->{
                finish()
            }
            R.id.menu_informacion->{
                val dialogoInfo = InfoDialog()
                dialogoInfo.show(supportFragmentManager,null)
            }
            R.id.menu_accion1->{}
            R.id.menu_accion2->{}
        }

        return super.onOptionsItemSelected(item)
    }


}