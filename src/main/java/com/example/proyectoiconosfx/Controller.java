package com.example.proyectoiconosfx;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Controller implements Initializable {



    private String enlaceFijo = "https://emojihub.herokuapp.com/api/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /*recoge un icono aleatorio y lo envia a la interfaz grafica*/
    public void aleatorio() {

        System.out.println(enlaceFijo);
        try {
            URL enlace=new URL(enlaceFijo+"random");
            ObjectMapper mapa=new ObjectMapper();
            Response respuesta=mapa.readValue(enlace,Response.class);
            String icono=respuesta.getUnicode().get(0);
            System.out.println(icono);

        }catch (IOException e){
            System.out.println(e);
        }

    }

    /**/
    public void buscarGrupo(){

        try {
            URL enlace = new URL(enlaceFijo + "all/group_animal_bird");
            ObjectMapper mapa = new ObjectMapper();
            Response respuesta=mapa.readValue(enlace,Response.class);
            




        }catch (IOException e){
            System.out.println(e);
        }
    }
/*
    public void buscarCategoria(ActionEvent actionEvent){

        try {
            URL enlace = new URL(enlaceFijo + "/group_face_positive");
            ObjectMapper mapa = new ObjectMapper();
            Response respuesta = mapa.readValue(enlace, Response.class);
            respuesta.getUnicode().stream().forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e);
        }


    }
 */


}
