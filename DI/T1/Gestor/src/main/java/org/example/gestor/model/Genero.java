package org.example.gestor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "generos")
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "genero")
    private List<Usuario> listaUsuarios;

    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
