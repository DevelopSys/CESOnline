package org.example.gestor.dao;

import org.example.gestor.data.HibernateUtils;
import org.example.gestor.model.Genero;
import org.example.gestor.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GeneroDAO {

    // todas las acciones contra BD del objeto usuario

    private Session session;
    public void getUsuarios() {

        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Genero genero = session.get(Genero.class,2);
        List<Usuario> listaUsuarios = genero.getListaUsuarios();
        for (Usuario usuario: listaUsuarios) {
            System.out.println(usuario.getNombre());
        }
        session.getTransaction().commit();
        session.close();

    }
}
