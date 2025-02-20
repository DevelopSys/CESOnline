package org.example.gestor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.gestor.MyApp;
import org.example.gestor.dao.UsuarioDAO;
import org.example.gestor.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<String> comboProfesion;
    private ObservableList<String> listaProfesiones;

    @FXML
    private Button botonRegistro, botonVolver;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField textoCorreo;

    @FXML
    private TextField textoDisponibilidad;

    @FXML
    private TextField textoNombre;

    @FXML
    private TextField textoPass;

    @FXML
    private TextField textoPass1;
    @FXML
    private VBox panelGeneral;

    private ToggleGroup grupoGenero;

    private UsuarioDAO usuarioDAO;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instancias();
        acciones();

    }

    private void acciones() {
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                textoDisponibilidad.setDisable(!newValue);
                if (!newValue) {
                    textoDisponibilidad.clear();
                }
            }

        });
        botonRegistro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // captura todos los texto
                String nombre = textoNombre.getText();
                String correo = textoCorreo.getText();
                String pass = textoPass.getText();
                String pass1 = textoPass1.getText();
                String profesion = comboProfesion.getSelectionModel().getSelectedItem();
                String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText();
                if (nombre.length() > 1 && correo.length() > 1 && pass.length() > 1
                        && (pass.equalsIgnoreCase(pass1)) && profesion.length() > 1) {
                    String disponibilidad = null;
                    if (checkDisponibilidad.isSelected()){
                        disponibilidad = textoDisponibilidad.getText();
                    }
                    Usuario usuario = new Usuario(nombre,correo,profesion,pass,disponibilidad);
                    usuarioDAO.agregarUsuario(usuario);
                    // cambiamos de pantalla
                    System.out.println("Registrando usuario");
                    // DataSet.listaUsuarios.add(usuario);

                    limpiarDatos();

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Correcto");
                    alerta.setContentText("Usuario creado correctamente");
                    alerta.show();

                    cambioPantallaLogin();
                    // crear un modelo
                } else {
                    System.out.println("Faltan datos");
                }

            }
        });
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cambioPantallaLogin();
            }
        });

    }

    private void cambioPantallaLogin(){
        Stage stageActual = (Stage) botonVolver.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(MyApp.class.getResource("login-view.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stageActual.setScene(scene);
            stageActual.setTitle("Login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void instancias() {
        usuarioDAO = new UsuarioDAO();
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().setAll(radioFemenino, radioMasculino);
        listaProfesiones = FXCollections.observableArrayList();
        listaProfesiones.addAll("Profesor", "Ingeniero", "Contable", "Administrativo", "Comercial");
        comboProfesion.setItems(listaProfesiones);
        comboProfesion.getSelectionModel().select(0);
    }
    private void limpiarDatos(){
        for ( Node elemento : panelGeneral.getChildren() ) {
            if(elemento instanceof TextField){
                ((TextField) elemento).clear();
            }
        }
        grupoGenero.selectToggle(radioFemenino);
    }
}
