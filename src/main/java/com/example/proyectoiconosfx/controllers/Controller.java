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
import javafx.scene.control.*;

import static com.example.proyectoiconosfx.controllers.Funcion_Guardado.*;


public class Controller implements Initializable {



    private String enlaceFijo = "https://emojihub.herokuapp.com/api/";

    @FXML
    private ComboBox catIdCombox;
    @FXML
    private ComboBox grupoIdCombox;

    @FXML
    private Label iconoLabel;

    @FXML
    private TableView<Icon> tableIcons;

    @FXML
    private CheckBox chkJson;

    @FXML
    private CheckBox chkXml;

    @FXML
    private CheckBox chkBin;

    @FXML
    private CheckBox chkTex;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*Carga los ComboBox*/
        ObservableList<String> itemsCat = FXCollections.observableArrayList();
        itemsCat.addAll("smileys_and_people", "animals_and_nature", "food_and_drink", "travel_and_places", "activities",
        "objects","symbols","flags");
        this.catIdCombox.setItems(itemsCat);

        ObservableList<String> itemsGroup = FXCollections.observableArrayList();
        itemsGroup.addAll("body", "cat_face", "clothing", "creature_face", "emotion","face_negative");
        this.grupoIdCombox.setItems(itemsGroup);

    }



    /**
     * Este método genera un emoticono aleatorio y lo muestra en la interfaz gráfica.
     * @param actionEvent detecta cuando se pulsa el botón correspondiente
     */
    @FXML
    public void aleatorio(ActionEvent actionEvent) {

        System.out.println(enlaceFijo);
        try {
            URL enlace=new URL(enlaceFijo+"random");
            ObjectMapper mapa=new ObjectMapper();
            Icon respuesta=mapa.readValue(enlace, Icon.class);
            String icono=respuesta.getUnicode().get(0);
            String substitucion=icono.replace("U+","0x");
            int entero=Integer.decode(substitucion);
            String iconoTraducido=new String(Character.toChars(entero));
            iconoLabel.setText(iconoTraducido);


            if (chkJson.isSelected()){
                json(new Icon[]{respuesta});
            }
            if (chkBin.isSelected()){
                bin(new Icon[]{respuesta});
            }
            if (chkXml.isSelected()){
                xml(new Icon[]{respuesta});
            }
            if (chkTex.isSelected()){
                txt(new Icon[]{respuesta});
            }

        }catch (IOException e){
            System.out.println(e);

        }

    }




    /**
     * Este método genera los emoticonos de un grupo concreto y los muestra en la tabla de la interfaz gráfica.
     * @param actionEvent detecta cuando se pulsa el botón correspondiente
     */
    public void buscarGrupo(ActionEvent actionEvent){

        try {
            if(!grupoIdCombox.getSelectionModel().isEmpty()){
                tableIcons.getItems().clear();
                URL enlace = new URL(enlaceFijo + "all/group_"+setgroupIdCombox());
                ObjectMapper mapa = new ObjectMapper();
                Icon[] respuesta=mapa.readValue(enlace, Icon[].class);
                List<Icon>listaIconos=Arrays.asList(respuesta);
                List<Icon>listaFinalIconos=traduccionIconos(listaIconos);
                tableIcons.getItems().addAll(listaFinalIconos);
                checkSave(respuesta);
            }


        }catch (IOException e){
            System.out.println(e);
        }
    }

    /**
     * Este método genera los emoticonos de una categoría en concreto y los muestra en la tabla de la interfaz gráfica.
     * @param actionEvent detecta cuando se pulsa el botón correspondiente
     */
    public void buscarCategoria(ActionEvent actionEvent){

        try {
            if(!catIdCombox.getSelectionModel().isEmpty()) {

                tableIcons.getItems().clear();
                URL enlace = new URL(enlaceFijo + "all/category_" + setCatIdCombox());
                ObjectMapper mapa = new ObjectMapper();
                Icon[] respuesta = mapa.readValue(enlace, Icon[].class);

                List<Icon> listaIconos = Arrays.asList(respuesta);

                List<Icon>listaFinalIconos=traduccionIconos(listaIconos);


                tableIcons.getItems().addAll(listaFinalIconos);
                checkSave(respuesta);
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }


    /**
     * Arranca la comboBox de las categorías, pasando al método de búsqueda la categoría deseada.
     * @return Devuelve la categoría a buscar.
     */
    public String  setCatIdCombox(){
        String selCat=catIdCombox.getSelectionModel().getSelectedItem().toString();
        System.out.println(selCat);
        return selCat;
    }


    /**
     * Arranca la comboBox de los grupos, pasando al método de búsqueda el grupo deseado.
     * @return Devuelve el grupo a buscar.
     */
    public String  setgroupIdCombox(){
        String selgroup=grupoIdCombox.getSelectionModel().getSelectedItem().toString();
        System.out.println(selgroup);
        return selgroup;
    }


    /**
     * Este método comprueba los checkBox seleccionados y ejecuta los metodos correspondientes para su guardado
     */
    public void checkSave(Icon[]datos){
        if (chkJson.isSelected()){
            json(datos);
        }
        if (chkBin.isSelected()){
            bin(datos);
        }
        if (chkXml.isSelected()){
            xml(datos);
        }
        if (chkTex.isSelected()){
            txt(datos);
        }
    }

    /**
     *
     *Metodo que modifica el código del emoji para hacerlo visible en java
     */
    public  List<Icon> traduccionIconos(List<Icon>iconos){
        List<Icon>listaFinalIconos=new ArrayList<>();
        Iterator<Icon>it=iconos.iterator();

        while(it.hasNext()){
            List<String>icono=new ArrayList<>();
            Icon icon=it.next();
            String iconoViejo=icon.getUnicode().get(0);
            String substitucion=iconoViejo.replace("U+","0x");
            int entero=Integer.decode(substitucion);
            String iconoTraducido=new String(Character.toChars(entero));
            icono.add(iconoTraducido);
            icon.setUnicode(icono);
            listaFinalIconos.add(icon);

            System.out.println(iconoTraducido);

        }
        return listaFinalIconos;
    }



}
