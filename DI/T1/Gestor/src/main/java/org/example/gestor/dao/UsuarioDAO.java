package org.example.gestor.dao;

import org.example.gestor.data.HibernateUtils;
import org.example.gestor.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UsuarioDAO {

    // todas las acciones contra BD del objeto usuario

    private Session session;

    public void agregarUsuario(Usuario usuario) {
        // INSERT INTO XXX (c,c,c,c,c) VALUES (x,x,x,x,x)
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(usuario);
        session.getTransaction().commit();
        session.close();
    }

    public Usuario getUsuario(String correo, String pass) {
        // SQL - HQL - get
        // SELECT * FROM USURAIOS WHERE ID = 1
        // resultSet -> while -> rs.getString("columna")
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // si el retorno depende de un id -> get
        // Usuario usuario = session.get(Usuario.class,1);
        // System.out.println(usuario.getNombre());
        /*Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
        List<Usuario> listaUsuarios = query.list();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)
                    && usuario.getPass().equalsIgnoreCase(pass)) {
                System.out.println(usuario.getNombre());
            }
        }*/
        Query<Usuario> query = session.createQuery("FROM Usuario u WHERE u.correo=:correo AND u.pass=:pass",
                Usuario.class);
        query.setParameter("correo",correo);
        query.setParameter("pass",pass);
        Usuario usuario = query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return usuario;
    }
}
