package com.example.proyectoiconosfx.controllers;

import com.example.proyectoiconosfx.HelloApplication;
import com.example.proyectoiconosfx.models.Icono;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPerfiles {

    private final String jdbcUrl = "jdbc:mysql://localhost:3306/perfilesbbdd";
    private Connection con;


    public DaoPerfiles() {
        try {
            con = DriverManager.getConnection(jdbcUrl, "root", "root");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public boolean comprobarUsuario(String nombre,String password){
        boolean valido=false;
        String resultado="";

        String busqueda = "select contrasenha from usuarios where nombre='"+nombre+"';";
        ResultSet rs;
        Statement stmt;
        try{
            System.out.println(busqueda);
            stmt=con.createStatement();
            rs=stmt.executeQuery(busqueda);
            while(rs.next()){
                resultado=rs.getString(1);

            }
        if(resultado.equals("")) {
            System.out.println("No existe el usuario");
        }else if(resultado.equals(password)){
            System.out.println("Bienvenido");
            valido=true;

        }else{
            System.out.println(resultado);
            System.out.println("La contraseña es incorrecta");
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return valido;

    }


}
