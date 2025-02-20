package org.example.gestor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String correo;
    @Column
    private String profesion;
    @Column
    private String pass;
    @Column
    private String disponibilidad;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero")
    private Genero genero;


    public Usuario(String nombre, String correo, String profesion, String pass, String disponibilidad) {
        this.nombre = nombre;
        this.correo = correo;
        this.profesion = profesion;
        this.pass = pass;
        this.disponibilidad = disponibilidad;
    }
}
