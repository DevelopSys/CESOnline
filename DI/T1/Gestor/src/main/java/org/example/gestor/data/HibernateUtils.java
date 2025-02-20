package org.example.gestor.data;

import org.hibernate.Filter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.nio.file.Path;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){

        if (sessionFactory == null){
            createSessionFactory();
        }
        return sessionFactory;
    }

    private void createSessionFactory() {
        File file = new File("src/main/resources/org/example/gestor/hibernate.cfg.xml");
        System.out.println(file.exists());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
    }


}
