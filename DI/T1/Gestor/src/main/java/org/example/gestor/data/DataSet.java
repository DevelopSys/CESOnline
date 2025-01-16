package org.example.gestor.data;

import org.example.gestor.model.Usuario;

import java.util.ArrayList;

public class DataSet {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void iniciarLista(){
        // String nombre, String correo, String profesion, String pass, String genero, String disponibilidad
        listaUsuarios.add(new Usuario("Borja","borja@gmail.com","profesor","123","Masculino","false"));
    }

    public static Usuario getUsuario(String correo, String pass){

        for (Usuario usuario: listaUsuarios) {
            if(usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getPass().equalsIgnoreCase(pass)){
                return usuario;
            }
        }

        return null;
    }
}
