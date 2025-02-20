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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.gestor.model.Equipo;
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
    private ImageView imagenDetalle;
    @FXML
    private Label textoPrincipal;

    @FXML
    private TableView<Equipo> tablaClasificacion;

    private ObservableList<Equipo> listaEquiposTabla;

    @FXML
    private TableColumn columnaPuesto, columnaEquipo, columnaPuntos;

    @FXML
    private ComboBox<Liga> comboLigas;
    private ObservableList<Liga> listaLigasCombo;

    @FXML
    private ListView<String> listViewLigas;
    private ObservableList<String> listaLigasListView;

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
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("No hay seleccion");
                    alert.show();
                } else {
                    String urlStr = String.format("https://www.thesportsdb.com/api/v1/json/3/lookuptable.php?l=%s&s=%s",
                            comboLigas.getSelectionModel().getSelectedItem().getIdLeague(),
                            listViewLigas.getSelectionModel().getSelectedItem()
                    );
                    try {
                        listaEquiposTabla.clear();
                        URL url = new URL(urlStr);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        JSONObject jsonObject = new JSONObject(reader.readLine());
                        JSONArray table = jsonObject.getJSONArray("table");
                        Gson gson = new Gson();
                        for (int i = 0; i < table.length(); i++) {
                            JSONObject team = table.getJSONObject(i);
                            Equipo equipo = gson.fromJson(team.toString(), Equipo.class);
                            listaEquiposTabla.add(equipo);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        comboLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Liga>() {
            @Override
            public void changed(ObservableValue<? extends Liga> observable,
                                Liga oldValue, Liga newValue) {
                // System.out.println(newValue.getIdLeague());
                listaLigasListView.clear();
                String urlString = "https://www.thesportsdb.com/api/v1/json/3/search_all_seasons.php?id=" + newValue.getIdLeague();
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
                    JSONArray results = jsonObject.getJSONArray("seasons");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject seasson = results.getJSONObject(i);
                        String seassonStr = seasson.getString("strSeason");
                        listaLigasListView.add(seassonStr);
                    }
                } catch (IOException e) {

                }

            }
        });
        tablaClasificacion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipo>() {
            @Override
            public void changed(ObservableValue<? extends Equipo> observable, Equipo oldValue, Equipo newValue) {
                // System.out.println(newValue.getStrDescription());
                // System.out.println(newValue.getStrBadge());
                imagenDetalle.setImage(new Image(newValue.getStrBadge()));
            }
        });
        /*listViewLigas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });*/
    }

    private void instancias() {
        listaEquiposTabla = FXCollections.observableArrayList(); // []
        listaLigasCombo = FXCollections.observableArrayList(); // []
        listaLigasListView = FXCollections.observableArrayList(); // []
        comboLigas.setItems(listaLigasCombo);
        listViewLigas.setItems(listaLigasListView);
        tablaClasificacion.setItems(listaEquiposTabla);
        columnaPuesto.setCellValueFactory(new PropertyValueFactory<>("intRank"));
        columnaEquipo.setCellValueFactory(new PropertyValueFactory<>("strTeam"));
        columnaPuntos.setCellValueFactory(new PropertyValueFactory<>("intPoints"));
    }
}
