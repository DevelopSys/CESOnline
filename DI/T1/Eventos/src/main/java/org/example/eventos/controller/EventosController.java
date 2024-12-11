package org.example.eventos.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.eventos.MyApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class EventosController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private TextArea registro;
    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnCuatro;

    @FXML
    private Button btnDos;

    @FXML
    private Button btnIgual;

    @FXML
    private Button btnSuma;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnUno, btnIzquierda, btnDerecha;

    @FXML
    private TextField textoNumeros;
    @FXML
    private GridPane panelNumeros;
    @FXML
    private HBox panelOperaciones;

    @FXML
    private BorderPane panelGeneral;
    @FXML
    private VBox panelIzquierdo, panelDerecho;
    private DropShadow sombra;
    private int operandoUno = 0;

    private boolean operando = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // empieza a generar la logica de la app
        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        // cuando se pasa por encima del boton, sombre
        // cuando se sale del boton se quita la sombra
        // cuando se pulsa en el boton pasa algo

        for (Node item : panelNumeros.getChildren()) {
            ((Button) item).setOnAction(this);
        }
        for (Node item : panelOperaciones.getChildren()) {
            ((Button) item).setOnAction(this);
            ((Button) item).setOnMouseExited(new ManejoRaton());
            ((Button) item).setOnMouseEntered(new ManejoRaton());
        }
    }

    private void instancias() {
        sombra = new DropShadow();
    }

    private void initGUI() {
        btnSuma.setGraphic(new ImageView(new Image(MyApplication.class.getResourceAsStream("mas.png"))));
        btnSuma.setBackground(null);
        btnIgual.setGraphic(new ImageView(new Image(MyApplication.class.getResourceAsStream("igual.png"))));
        btnIgual.setBackground(null);
        btnBorrar.setGraphic(new ImageView(new Image(MyApplication.class.getResourceAsStream("borrar.png"))));
        btnBorrar.setBackground(null);
    }

    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (event.getSource() == btnIzquierda) {
            if (panelGeneral.getLeft()==null){
                panelGeneral.setLeft(panelIzquierdo);
            } else {
                panelGeneral.setLeft(null);
            }

        } else if (event.getSource() == btnDerecha) {
            if (panelGeneral.getRight()==null){
                panelGeneral.setRight(panelDerecho);
            } else {
                panelGeneral.setRight(null);
            }
        } else if (event.getSource() == btnBorrar) {
            textoNumeros.clear();
        } else if (event.getSource() == btnSuma) {
            operando = true;
        } else if (event.getSource() == btnIgual) {
            int resultado = operandoUno + Integer.valueOf(textoNumeros.getText());
            textoNumeros.setText(String.valueOf(resultado));
            operando = true;
        } else {
            registro.appendText("\n");

            if (!operando) {
                textoNumeros.appendText(button.getText());
            } else {
                operandoUno = Integer.valueOf(textoNumeros.getText());
                textoNumeros.setText(button.getText());
                operando = false;
            }
        }
    }


    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                Button button = ((Button) event.getSource());
                button.setEffect(sombra);
                button.setCursor(Cursor.HAND);
                System.out.println("Escuchado evento de raton entrando");
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                Button button = ((Button) event.getSource());
                button.setEffect(null);
                button.setCursor(Cursor.CROSSHAIR);
            }

        }
    }

}


