package org.example.gestor.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gestor.MyApp;
import org.example.gestor.data.DataSet;
import org.example.gestor.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoginController implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistro;
    @FXML
    private ProgressBar barraCarga;

    @FXML
    private TextField editCorreo;

    @FXML
    private TextField editPass;

    private Task<Void> tareaSecundaria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        if (DataSet.listaUsuarios.size() == 0) {
            DataSet.iniciarLista();
        }
        initGUI();
        acciones();
    }

    private void initGUI() {
        barraCarga.progressProperty().bind(tareaSecundaria.progressProperty());
    }

    private void instancias() {
        tareaSecundaria = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                for (int i = 0; i < 101; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(50);
                    // System.out.println("actualizando");
                }

                // cambiar de pantalla - con cambio de contexto correcto
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage stageActual = (Stage) btnLogin.getScene().getWindow();
                        Stage stageMain = new Stage();
                        FXMLLoader loader = new FXMLLoader(MyApp.class.getResource("main-view.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                            Scene scene = new Scene(root);
                            stageMain.setScene(scene);
                            stageMain.setTitle("Principal");
                            stageMain.show();
                            stageActual.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });
                return null;
            }
        };
    }

    private void acciones() {
        btnLogin.setOnAction(this);
        btnRegistro.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Node node = (Node) event.getSource();
        if (node == btnLogin) {

            if (!editCorreo.getText().isEmpty() && !editPass.getText().isEmpty()) {
                Usuario usuario = DataSet.getUsuario(editCorreo.getText().toString(), editPass.getText().toString());
                // cuando el usuario != null
                if (usuario != null) {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Login OK");
                    alerta.setContentText("Vas a entrar al sistema");
                    alerta.show();
                    Thread thread = new Thread(tareaSecundaria);
                    thread.start();
                    // tareaSecundaria.
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Login fail");
                    alerta.setContentText("fallo de credenciales");
                    alerta.show();
                }

            } else {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Error");
                alerta.setContentText("Error, faltan datos por rellenar");
                alerta.show();
            }

        } else if (node == btnRegistro) {

            Stage stageActual = (Stage) node.getScene().getWindow();
            Stage stageRegistro = new Stage();
            // 1. creo una escena
            FXMLLoader loader = new FXMLLoader(MyApp.class.getResource("register-view.fxml"));
            Parent root = null;
            try {
                root = loader.load();
                Scene scene = new Scene(root);
                stageActual.setScene(scene);
                stageActual.setTitle("Registro");
                // 2. La pongo en una ventana nueva
                // stageRegistro.setScene(scene);
                // 3. Muestra la nueva ventana
                //stageRegistro.setTitle("Registrar");
                // stageRegistro.initModality(Modality.WINDOW_MODAL);
                // stageRegistro.initOwner(node.getScene().getWindow());
                // stageRegistro.showAndWait();
                // 4. Cerrar la actual
                // stageActual.close();
            } catch (IOException e) {
                System.out.println("Error en la carga de la escena");
                System.out.println(e.getCause());
            }
        }
    }
}

// LOGIN
// stage
// scene ->loader-> fxml

// REGISTRO
// stage
// scene ->loader-> fxml