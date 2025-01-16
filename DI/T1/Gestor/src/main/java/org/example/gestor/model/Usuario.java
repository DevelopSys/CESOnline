package org.example.gestor.model;


import java.io.Serializable;



public class Usuario implements Serializable {

    private String nombre;
    private String correo;
    private String profesion;
    private String pass;
    private String genero;
    private String disponibilidad;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String profesion, String pass, String genero, String disponibilidad) {
        this.nombre = nombre;
        this.correo = correo;
        this.profesion = profesion;
        this.pass = pass;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
    }

    // getter setter constructorAll constructorNada


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
