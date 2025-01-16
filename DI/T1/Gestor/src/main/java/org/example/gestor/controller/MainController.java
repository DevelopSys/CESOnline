package org.example.gestor.controller;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.gestor.model.Liga;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label textoPrincipal;

    @FXML
    private ComboBox<Liga> comboLigas;
    private ObservableList<Liga> listaLigasCombo;

    @FXML
    private ListView<Liga> listViewLigas;
    private ObservableList<Liga> listaLigasListView;

    @FXML
    private Button botonConsulta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        consultarDatos();
        acciones();
    }

    private void consultarDatos() {
        String urlString = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String stringJSON = reader.readLine();
            /*String lectura = null;
            StringBuffer stringBuffer = new StringBuffer();
            while ((lectura = reader.readLine())!=null){
                stringBuffer.append(lectura);
            }*/
            JSONObject jsonObject = new JSONObject(stringJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("leagues");
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject liga = jsonArray.getJSONObject(i);
                Liga ligaOBJ = gson.fromJson(liga.toString(), Liga.class);
                if (ligaOBJ.getStrSport().equalsIgnoreCase("soccer")) {
                    // System.out.println(ligaOBJ.getStrLeague());
                    listaLigasCombo.addAll(ligaOBJ);
                }
            }


        } catch (MalformedURLException e) {
            System.out.println("URL invalida");
        } catch (IOException e) {
            System.out.println("Error en la conexion con el servidor");
        }
    }

    private void acciones() {
        botonConsulta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // comboLigas.getValue() == null
                if (listViewLigas.getSelectionModel().getSelectedIndex() == -1) {
                    // Alert con el aviso de que no hay nada seleccionado
                } else {
                    Liga liga = listViewLigas.getSelectionModel().getSelectedItem();


                    // Liga liga = comboLigas.getValue();
                    // Liga liga = comboLigas.getSelectionModel().getSelectedItem();
                    // System.out.println(liga.getId());
                    // System.out.println(liga.getNombre());
                }

            }
        });
        comboLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Liga>() {
            @Override
            public void changed(ObservableValue<? extends Liga> observable,
                                Liga oldValue, Liga newValue) {


            }
        });
        listViewLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Liga>() {
            @Override
            public void changed(ObservableValue observable, Liga oldValue, Liga newValue) {
                System.out.println(newValue);
            }
        });
    }

    private void instancias() {
        listaLigasCombo = FXCollections.observableArrayList(); // []
        listaLigasListView = FXCollections.observableArrayList(); // []
        comboLigas.setItems(listaLigasCombo);
        listViewLigas.setItems(listaLigasListView);
    }
}
