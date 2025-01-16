module org.example.gestor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.json;
    requires com.google.gson;


    opens org.example.gestor to javafx.fxml, org.json , com.google.gson;
    exports org.example.gestor;

    opens org.example.gestor.controller to javafx.fxml,org.json,com.google.gson;
    exports org.example.gestor.controller;

    opens org.example.gestor.model to javafx.fxml,org.json, com.google.gson;
    exports org.example.gestor.model;
}