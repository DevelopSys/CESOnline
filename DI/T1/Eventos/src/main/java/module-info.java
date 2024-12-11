module org.example.eventos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;


    opens org.example.eventos to javafx.fxml;
    exports org.example.eventos;
    exports org.example.eventos.controller;
    opens org.example.eventos.controller to javafx.fxml;


}