module org.example.gestor {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    requires com.google.gson;
    requires mysql.connector.j;
    requires java.sql;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires static lombok;


    opens org.example.gestor to javafx.fxml, org.json , com.google.gson, lombok, mysql.connector.j, java.sql,org.hibernate.orm.core,jakarta.persistence, java.naming;
    exports org.example.gestor;

    opens org.example.gestor.controller to javafx.fxml,org.json,com.google.gson, lombok, java.sql, mysql.connector.j,org.hibernate.orm.core, jakarta.persistence, java.naming;
    exports org.example.gestor.controller;

    opens org.example.gestor.model to javafx.fxml,org.json, com.google.gson, lombok, java.sql, mysql.connector.j, org.hibernate.orm.core, jakarta.persistence, java.naming;
    exports org.example.gestor.model;
    exports org.example.gestor.data;
    opens org.example.gestor.data to com.google.gson, jakarta.persistence, java.naming, java.sql, javafx.fxml, lombok, mysql.connector.j, org.hibernate.orm.core, org.json;
}