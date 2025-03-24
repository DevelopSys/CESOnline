package com.example.agendanavegada.dataset

import com.example.agenda.model.Usuario


class DataSet {

    companion object {

        val lista: ArrayList<Usuario> = arrayListOf(
            Usuario("borja@gmail.com", "1234"),
            Usuario("juan@gmail.com", "2345"),
            Usuario("luis@gmail.com", "3456"),
            Usuario("jose@gmail.com", "4567"),
        )


        fun comprobarLogin(correo: String, pass: String): Usuario? {
            return lista.find{ it.nombre.equals(correo)  };
        }

        fun insertarUsuario(nombre: String, pass: String, perfil: String): Unit {
            lista.add(Usuario(nombre,pass,perfil))

        }
    }
}