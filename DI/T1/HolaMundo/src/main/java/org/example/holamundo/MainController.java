package org.example.holamundo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Label labelSaludo;
    @FXML
    public TextField textoNombre;
    @FXML
    private Button btnCerrar, btnSaludar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnSaludar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String texto = textoNombre.getText();
                if (!texto.isEmpty()){
                    labelSaludo.setText(String.format("Enhorabuena %s, has completado el primer proyecto",texto));
                } else {
                    System.out.println("No hay nombre");
                }
            }
        });
    }
}
