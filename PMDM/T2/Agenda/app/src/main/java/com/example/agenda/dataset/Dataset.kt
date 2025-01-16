package com.example.agenda.dataset

import com.example.agenda.model.Usuario

class Dataset {

    companion object {

        val lista: ArrayList<Usuario> = arrayListOf(
            Usuario("borja@gmail.com", "1234"),
            Usuario("juan@gmail.com", "2345"),
            Usuario("luis@gmail.com", "3456"),
            Usuario("jose@gmail.com", "4567"),
        )


        fun comprobarLogin(correo: String, pass: String): Usuario? {
            return lista.find{ it.nombre.equals(correo) && it.pass.equals(pass) };
        }

        fun insertarUsuario(nombre: String, pass: String, perfil: String): Unit {
            lista.add(Usuario(nombre,pass,perfil))

        }
    }
}