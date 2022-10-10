package com.example.proyectoiconosfx.controllers;

import com.example.proyectoiconosfx.models.Icon;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class Funcion_Guardado {

    public static void json(Icon[] iconosJ){

        try(ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream("com/example/proyectoiconosfx/ficheros/ficheroJson.json"))){

            flujo.writeObject(iconosJ);


        }catch (Exception e){
            System.out.println("Error: "+ e);
        }

    }


    public static void bin(Icon[] iconosB){
        try(ObjectOutputStream flujo = new ObjectOutputStream(new FileOutputStream("com/example/proyectoiconosfx/ficheros/ficheroBinario.bin"))){

            flujo.writeObject(iconosB);


        }catch (Exception e){
            System.out.println("Error: "+ e);
        }
    }

    public static void xml(Icon[] iconosX){
        try {

        } catch (Exception exc) {
            System.out.println("Error: "+exc);
        }
    }

    public static void txt(Icon[] iconosT){



        try(BufferedWriter bw = new BufferedWriter(new FileWriter("com/example/proyectoiconosfx/ficheros/ficheroTexto.txt"))){

            for (int i = 0; i < iconosT.length; i++){
                bw.write(String.valueOf(iconosT[i])+"\n");

            }


        }catch (Exception ex){
            System.out.println("Error: "+ ex);
        }


    }
}
