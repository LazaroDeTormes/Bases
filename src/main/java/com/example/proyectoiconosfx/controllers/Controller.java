package com.example.proyectoiconosfx.controllers;

import com.example.proyectoiconosfx.models.Icon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;


public class Controller implements Initializable {



    private String enlaceFijo = "https://emojihub.herokuapp.com/api/";

    @FXML
    private ComboBox catIdCombox;
    @FXML
    private ComboBox grupoIdCombox;

    @FXML
    private Label iconoLabel;

    @FXML
    private TableColumn nombre



    /*Carga los ComboBox*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hola");
        ObservableList<String> itemsCat = FXCollections.observableArrayList();
        itemsCat.addAll("smileys_and_people", "animals_and_nature", "food_and_drink", "travel_and_places", "activities",
        "objects","symbols","flags");
        this.catIdCombox.setItems(itemsCat);

        ObservableList<String> itemsGroup = FXCollections.observableArrayList();
        itemsGroup.addAll("body", "cat_face", "clothing", "creature_face", "emotion","face_negative");
        this.grupoIdCombox.setItems(itemsGroup);

    }

    /*recoge un icono aleatorio y lo envia a la interfaz grafica*/


    @FXML
    public void aleatorio(ActionEvent actionEvent) {

        System.out.println(enlaceFijo);
        try {
            URL enlace=new URL(enlaceFijo+"random");
            ObjectMapper mapa=new ObjectMapper();
            Icon respuesta=mapa.readValue(enlace, Icon.class);
            String icono=respuesta.getUnicode().get(0);
            iconoLabel.setText(icono);
            System.out.println(icono);

        }catch (IOException e){
            System.out.println(e);

        }

    }



    /*Envia un grupo de iconos segun el grupo seleccionado*/

    public void buscarGrupo(ActionEvent actionEvent){

        try {

            URL enlace = new URL(enlaceFijo + "all/group_"+setgroupIdCombox());
            ObjectMapper mapa = new ObjectMapper();

            Icon[] respuesta=mapa.readValue(enlace, Icon[].class);

            for(Icon a : respuesta){
                System.out.println("\\" + a.getUnicode().get(0));

            }


        }catch (IOException e){
            System.out.println(e);
        }
    }
    /*Envia un grupo de iconos segun la categoria seleccionada*/
    public void buscarCategoria(ActionEvent actionEvent){

        try {
            URL enlace = new URL(enlaceFijo + "all/category_"+setCatIdCombox());
            ObjectMapper mapa = new ObjectMapper();
            Icon[] respuesta=mapa.readValue(enlace, Icon[].class);

            for(Icon a : respuesta){
                System.out.println(a.getUnicode());
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }
    /*Pasa String de la categoria seleccionada*/
    public String  setCatIdCombox(){
        String selCat=catIdCombox.getSelectionModel().getSelectedItem().toString();
        System.out.println(selCat);
        return selCat;
    }
    /*Pasa Stgring del Grupo seleccionado*/
    public String  setgroupIdCombox(){
        String selgroup=grupoIdCombox.getSelectionModel().getSelectedItem().toString();
        System.out.println(selgroup);
        return selgroup;
    }


}
