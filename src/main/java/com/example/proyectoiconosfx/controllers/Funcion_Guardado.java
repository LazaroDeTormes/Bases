package com.example.proyectoiconosfx.controllers;

import com.example.proyectoiconosfx.models.Icon;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Funcion_Guardado implements Serializable {

    /**
     * En este método creamos un fichero JSON en el que pasamos los iconos seleccionados
     *
     *
     * @param iconosJ lista de emoticonos
     */
    public static void json(Icon[] iconosJ){

        ObjectMapper mapa = new ObjectMapper();

        try {
            File json = new File ("res/ficheros/ficheroJson.json");


            mapa.writeValue(json, iconosJ);


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * En este método creamos un fichero JSON en el que pasamos los iconos seleccionados
     *
     *
     * @param iconosB lista de emoticonos
     */
    public static void bin(Icon[] iconosB){



        try(ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream("res/ficheros/ficheroBinario.bin"))){

            flujo.writeObject(iconosB);


        }catch (Exception e){
            System.out.println("Error: "+ e);
        }
    }




    /**
     * En este método creamos un fichero JSON en el que pasamos los iconos seleccionados
     *
     *
     * @param iconosX lista de emoticonos
     */
    public static void xml(Icon[] iconosX){
        XmlMapper mapaX = new XmlMapper();
        try {
            File xml = new File ("res/ficheros/ficheroXml.xml");
            mapaX.writeValue(xml, iconosX);

        } catch (Exception exc) {
            System.out.println("Error: "+exc);
        }
    }



    /**
     * En este método creamos un fichero JSON en el que pasamos los iconos seleccionados
     *
     *
     * @param iconosT lista de emoticonos
     */
    public static void txt(Icon[] iconosT){



        try(BufferedWriter bw = new BufferedWriter(new FileWriter("res/ficheros/ficheroTexto.txt"))){

            for (int i = 0; i < iconosT.length; i++){
                bw.write(String.valueOf(iconosT[i])+"\n");

            }


        }catch (Exception ex){
            System.out.println("Error: "+ ex);
        }


    }
}
